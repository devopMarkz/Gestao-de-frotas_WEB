package com.marcos.gestao_de_frota.dto.veiculo;

import jakarta.validation.constraints.PositiveOrZero;

public class CaminhaoDto extends VeiculoDto{

    private Double capacidadeCarga;
    private Integer numeroDeEixos;

    public CaminhaoDto(Long id, Boolean disponivel, String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, String categoriaVeiculo, Double capacidadeCarga, Integer numeroDeEixos) {
        super(id, disponivel, marca, modelo, anoFabricacao, capacidade, custoPorDia, categoriaVeiculo);
        this.capacidadeCarga = capacidadeCarga;
        this.numeroDeEixos = numeroDeEixos;
    }

    public Double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public Integer getNumeroDeEixos() {
        return numeroDeEixos;
    }
}
