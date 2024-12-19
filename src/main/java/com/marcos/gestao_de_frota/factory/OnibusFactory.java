package com.marcos.gestao_de_frota.factory;

import com.marcos.gestao_de_frota.dto.veiculo.CreateVeiculoDto;
import com.marcos.gestao_de_frota.entities.Onibus;
import com.marcos.gestao_de_frota.entities.Veiculo;
import com.marcos.gestao_de_frota.entities.enums.CategoriaVeiculo;
import org.springframework.stereotype.Component;

@Component("onibusFactory")
public class OnibusFactory implements VeiculoFactory{
    @Override
    public Veiculo criarVeiculo(CreateVeiculoDto createVeiculoDto) {
        Onibus onibus = new Onibus();
        onibus.setDisponivel(createVeiculoDto.getDisponivel());
        onibus.setPlaca(createVeiculoDto.getPlaca());
        onibus.setMarca(createVeiculoDto.getMarca());
        onibus.setModelo(createVeiculoDto.getModelo());
        onibus.setAnoFabricacao(createVeiculoDto.getAnoFabricacao());
        onibus.setCapacidade(createVeiculoDto.getCapacidade());
        onibus.setCustoPorDia(createVeiculoDto.getCustoPorDia());
        onibus.setCategoriaVeiculo(CategoriaVeiculo.valueOf(createVeiculoDto.getCategoriaVeiculo().toUpperCase()));
        Integer numeroDeAssentos = (createVeiculoDto.getAtributosEspecificos().containsKey("numeroDeAssentos"))? (Integer) createVeiculoDto.getAtributosEspecificos().get("numeroDeAssentos") : null;
        onibus.setNumeroDeAssentos(numeroDeAssentos);
        return onibus;
    }
}
