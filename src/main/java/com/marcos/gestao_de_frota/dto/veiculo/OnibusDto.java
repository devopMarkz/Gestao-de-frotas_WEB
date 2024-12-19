package com.marcos.gestao_de_frota.dto.veiculo;

public class OnibusDto extends VeiculoDto{

    private Integer numeroDeAssentos;

    public OnibusDto(Long id, Boolean disponivel, String placa, String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, String categoriaVeiculo, Integer numeroDeAssentos) {
        super(id, disponivel, placa, marca, modelo, anoFabricacao, capacidade, custoPorDia, categoriaVeiculo);
        this.numeroDeAssentos = numeroDeAssentos;
    }

    public Integer getNumeroDeAssentos() {
        return numeroDeAssentos;
    }
}
