package com.marcos.gestao_de_frota.dto.veiculo;

import jakarta.validation.constraints.PositiveOrZero;

public class CaminhaoDto extends VeiculoDto{

    private Integer numeroDeEixos;

    public CaminhaoDto(Long id, Boolean disponivel, String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, String categoriaVeiculo, Integer numeroDeEixos) {
        super(id, disponivel, marca, modelo, anoFabricacao, capacidade, custoPorDia, categoriaVeiculo);
        this.numeroDeEixos = numeroDeEixos;
    }

    public Integer getNumeroDeEixos() {
        return numeroDeEixos;
    }
}
