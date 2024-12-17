package com.marcos.gestao_de_frota.dto.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class VeiculoDto {

    private Long id;
    private Boolean disponivel;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Double capacidade;
    private Double custoPorDia;
    private String categoriaVeiculo;

    public VeiculoDto(Long id, Boolean disponivel, String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, String categoriaVeiculo) {
        this.id = id;
        this.disponivel = disponivel;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.capacidade = capacidade;
        this.custoPorDia = custoPorDia;
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public Long getId() {
        return id;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public Double getCustoPorDia() {
        return custoPorDia;
    }

    public String getCategoriaVeiculo() {
        return categoriaVeiculo;
    }
}
