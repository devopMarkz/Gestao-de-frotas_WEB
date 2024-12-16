package com.marcos.gestao_de_frota.entities;

import com.marcos.gestao_de_frota.entities.enums.CategoriaVeiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_onibus")
@PrimaryKeyJoinColumn(name = "veiculo_id")
public class Onibus extends Veiculo{

    private Integer numeroDeAssentos;

    public Onibus() {
    }

    public Onibus(Long id, Boolean disponivel, String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, CategoriaVeiculo categoriaVeiculo, Integer numeroDeAssentos) {
        super(id, disponivel, marca, modelo, anoFabricacao, capacidade, custoPorDia, categoriaVeiculo);
        this.numeroDeAssentos = numeroDeAssentos;
    }

    public Integer getNumeroDeAssentos() {
        return numeroDeAssentos;
    }

    public void setNumeroDeAssentos(Integer numeroDeAssentos) {
        this.numeroDeAssentos = numeroDeAssentos;
    }
}
