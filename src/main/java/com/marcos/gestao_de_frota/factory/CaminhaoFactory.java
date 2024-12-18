package com.marcos.gestao_de_frota.factory;


import com.marcos.gestao_de_frota.dto.veiculo.CreateVeiculoDto;
import com.marcos.gestao_de_frota.entities.Caminhao;
import com.marcos.gestao_de_frota.entities.Veiculo;
import com.marcos.gestao_de_frota.entities.enums.CategoriaVeiculo;
import org.springframework.stereotype.Component;

@Component("caminhaoFactory")
public class CaminhaoFactory implements VeiculoFactory{

    @Override
    public Veiculo criarVeiculo(CreateVeiculoDto createVeiculoDto) {
        Caminhao caminhao = new Caminhao();
        caminhao.setDisponivel(createVeiculoDto.getDisponivel());
        caminhao.setMarca(createVeiculoDto.getMarca());
        caminhao.setModelo(createVeiculoDto.getModelo());
        caminhao.setAnoFabricacao(createVeiculoDto.getAnoFabricacao());
        caminhao.setCapacidade(createVeiculoDto.getCapacidade());
        caminhao.setCustoPorDia(createVeiculoDto.getCustoPorDia());
        caminhao.setCategoriaVeiculo(CategoriaVeiculo.valueOf(createVeiculoDto.getCategoriaVeiculo().toUpperCase()));
        Integer numeroDeEixos = (createVeiculoDto.getAtributosEspecificos().containsKey("numeroDeEixos"))? (Integer) createVeiculoDto.getAtributosEspecificos().get("numeroDeEixos") : null;
        caminhao.setNumeroDeEixos(numeroDeEixos);
        return caminhao;
    }

}
