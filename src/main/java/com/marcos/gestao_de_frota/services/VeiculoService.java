package com.marcos.gestao_de_frota.services;

import com.marcos.gestao_de_frota.dto.veiculo.CreateVeiculoDto;
import com.marcos.gestao_de_frota.dto.veiculo.VeiculoDto;
import com.marcos.gestao_de_frota.entities.Caminhao;
import com.marcos.gestao_de_frota.factory.VeiculoFactory;
import com.marcos.gestao_de_frota.repositories.VeiculoRepository;
import com.marcos.gestao_de_frota.utils.ConvertEntityToDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;
    private VeiculoFactory veiculoFactory; // testando com caminhão

    public VeiculoService(VeiculoRepository veiculoRepository, @Qualifier("caminhaoFactory") VeiculoFactory veiculoFactory){
        this.veiculoRepository = veiculoRepository;
        this.veiculoFactory = veiculoFactory;
    }

    @Transactional
    public VeiculoDto insert(CreateVeiculoDto createVeiculoDto){
        if(createVeiculoDto.getCategoriaVeiculo().equalsIgnoreCase("CAMINHAO")) {
            Caminhao caminhao = (Caminhao) veiculoFactory.criarVeiculo(createVeiculoDto);
            caminhao = veiculoRepository.save(caminhao);
            return ConvertEntityToDto.convertToCaminhaoDto(caminhao);
        }
        throw new IllegalArgumentException("Veículo inexistente.");
    }

}
