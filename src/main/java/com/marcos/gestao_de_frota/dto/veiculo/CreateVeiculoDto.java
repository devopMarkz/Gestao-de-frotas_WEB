package com.marcos.gestao_de_frota.dto.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.HashMap;
import java.util.Map;

public class CreateVeiculoDto {

    @NotBlank(message = "Campo não pode estar nulo ou vazio.")
    private String categoriaVeiculo;

    private Boolean disponivel = true;

    @NotBlank(message = "A placa do veículo deve ser informada.")
    private String placa;

    @NotBlank(message = "Campo não pode estar nulo ou vazio.")
    private String marca;

    @NotBlank(message = "Campo não pode estar nulo ou vazio.")
    private String modelo;

    @PositiveOrZero(message = "O ano de fabricação deve ser positivo")
    private Integer anoFabricacao;

    @PositiveOrZero(message = "A capacidade deve ser positiva.")
    private Double capacidade;

    @PositiveOrZero(message = "O custo por dia deve ser positivo.")
    private Double custoPorDia;

    private Map<String, Object> atributosEspecificos = new HashMap<>();

    public CreateVeiculoDto(String categoriaVeiculo, String placa, String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia) {
        this.categoriaVeiculo = categoriaVeiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.capacidade = capacidade;
        this.custoPorDia = custoPorDia;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public String getPlaca() {
        return placa;
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

    public Map<String, Object> getAtributosEspecificos() {
        return atributosEspecificos;
    }
}
