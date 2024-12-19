package com.marcos.gestao_de_frota.entities;

import com.marcos.gestao_de_frota.entities.enums.CategoriaVeiculo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_veiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean disponivel;

    @Column(unique = true)
    private String placa;

    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Double capacidade;
    private Double custoPorDia;

    @Enumerated(EnumType.STRING)
    private CategoriaVeiculo categoriaVeiculo;

    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private List<Viagem> viagens;

    public Veiculo() {
    }

    public Veiculo(Long id, Boolean disponivel, String placa, String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, CategoriaVeiculo categoriaVeiculo) {
        this.id = id;
        this.disponivel = disponivel;
        this.placa = placa;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Double capacidade) {
        this.capacidade = capacidade;
    }

    public Double getCustoPorDia() {
        return custoPorDia;
    }

    public void setCustoPorDia(Double custoPorDia) {
        this.custoPorDia = custoPorDia;
    }

    public CategoriaVeiculo getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Veiculo veiculo = (Veiculo) object;
        return Objects.equals(id, veiculo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
