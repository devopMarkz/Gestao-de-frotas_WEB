package com.marcos.gestao_de_frota.entities;

import com.marcos.gestao_de_frota.entities.enums.CategoriaVeiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_caminhoes")
@PrimaryKeyJoinColumn(name = "veiculo_id")
public class Caminhao extends Veiculo {

    private Double capacidadeCarga;
    private Integer numeroDeEixos;

    public Caminhao() {
    }

    public Caminhao(Long id, Boolean disponivel, String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, CategoriaVeiculo categoriaVeiculo, Double capacidadeCarga, Integer numeroDeEixos) {
        super(id, disponivel, marca, modelo, anoFabricacao, capacidade, custoPorDia, categoriaVeiculo);
        this.capacidadeCarga = capacidadeCarga;
        this.numeroDeEixos = numeroDeEixos;
    }

    public Double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(Double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public Integer getNumeroDeEixos() {
        return numeroDeEixos;
    }

    public void setNumeroDeEixos(Integer numeroDeEixos) {
        this.numeroDeEixos = numeroDeEixos;
    }
}
