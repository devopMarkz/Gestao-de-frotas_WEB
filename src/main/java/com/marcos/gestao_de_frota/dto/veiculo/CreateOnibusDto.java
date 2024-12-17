package com.marcos.gestao_de_frota.dto.veiculo;

import jakarta.validation.constraints.PositiveOrZero;

public class CreateOnibusDto extends CreateVeiculoDto{

    @PositiveOrZero(message = "Número de assentos deve ser positivo.")
    private Integer numeroDeAssentos;

    public CreateOnibusDto(String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, String categoriaVeiculo, Integer numeroDeAssentos) {
        super(marca, modelo, anoFabricacao, capacidade, custoPorDia, categoriaVeiculo);
        this.numeroDeAssentos = numeroDeAssentos;
    }

    public Integer getNumeroDeAssentos() {
        return numeroDeAssentos;
    }
}
