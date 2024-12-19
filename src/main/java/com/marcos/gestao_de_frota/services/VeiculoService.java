package com.marcos.gestao_de_frota.services;

import com.marcos.gestao_de_frota.dto.veiculo.CreateVeiculoDto;
import com.marcos.gestao_de_frota.dto.veiculo.VeiculoDto;
import com.marcos.gestao_de_frota.entities.Caminhao;
import com.marcos.gestao_de_frota.entities.Onibus;
import com.marcos.gestao_de_frota.entities.Veiculo;
import com.marcos.gestao_de_frota.factory.VeiculoFactory;
import com.marcos.gestao_de_frota.repositories.VeiculoRepository;
import com.marcos.gestao_de_frota.services.exceptions.VeiculoInexistenteException;
import com.marcos.gestao_de_frota.services.exceptions.VeiculoInvalidoException;
import com.marcos.gestao_de_frota.utils.ConvertEntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;
    private Map<String, VeiculoFactory> factories;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository, Map<String, VeiculoFactory> factories) {
        this.veiculoRepository = veiculoRepository;
        this.factories = factories;
    }

    @Transactional
    public VeiculoDto insert(CreateVeiculoDto createVeiculoDto) {
        // Recupera a fábrica com base na categoria do veículo
        String tipo = createVeiculoDto.getCategoriaVeiculo().toLowerCase() + "Factory";
        VeiculoFactory factory = factories.get(tipo);

        if (factory == null) {
            throw new VeiculoInvalidoException("Tipo de veículo inválido: " + createVeiculoDto.getCategoriaVeiculo());
        }

        Veiculo veiculo = factory.criarVeiculo(createVeiculoDto);

        veiculo = veiculoRepository.save(veiculo);

        return convertToDto(veiculo);
    }

    @Transactional(readOnly = true)
    public Page<VeiculoDto> getAll(String disponivel, String categoriaVeiculo, Pageable pageable) {
        Boolean disponibilidade = Boolean.parseBoolean(disponivel);
        categoriaVeiculo = categoriaVeiculo.toUpperCase();
        Page<Veiculo> veiculos = (categoriaVeiculo.isEmpty()) ? veiculoRepository.findByDisponivel(disponibilidade, pageable) : veiculoRepository.searchAll(disponibilidade, categoriaVeiculo, pageable);
        return veiculos.map(this::convertToDto);
    }

    @Transactional(readOnly = true)
    public VeiculoDto getByPlaca(String placa){
        Veiculo veiculo = veiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new VeiculoInexistenteException("O veículo com placa " + placa + " não contém cadastro no sistema."));
        return convertToDto(veiculo);
    }

    private VeiculoDto convertToDto(Veiculo veiculo) {
        return switch (veiculo.getCategoriaVeiculo().name()) {
            case "CAMINHAO" -> ConvertEntityToDto.convertToCaminhaoDto((Caminhao) veiculo);
            case "ONIBUS" -> ConvertEntityToDto.convertToOnibusDto((Onibus) veiculo);
            default -> throw new VeiculoInvalidoException("Tipo de veículo inválido.");
        };
    }

}
