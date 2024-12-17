package com.marcos.gestao_de_frota.dto.veiculo;

import jakarta.validation.constraints.PositiveOrZero;

public class CreateCaminhaoDto extends CreateVeiculoDto{

    @PositiveOrZero(message = "Capacidade de carga deve ser positivo.")
    private Double capacidadeCarga;

    @PositiveOrZero(message = "Número de eixos deve ser positivo.")
    private Integer numeroDeEixos;

    public CreateCaminhaoDto(String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, String categoriaVeiculo, Double capacidadeCarga, Integer numeroDeEixos) {
        super(marca, modelo, anoFabricacao, capacidade, custoPorDia, categoriaVeiculo);
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
