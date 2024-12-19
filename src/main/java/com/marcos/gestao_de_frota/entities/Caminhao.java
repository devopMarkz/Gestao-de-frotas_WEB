package com.marcos.gestao_de_frota.entities;

import com.marcos.gestao_de_frota.entities.enums.CategoriaVeiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_caminhao")
@PrimaryKeyJoinColumn(name = "veiculo_id")
public class Caminhao extends Veiculo {

    private Integer numeroDeEixos;

    public Caminhao() {
    }

    public Caminhao(Long id, Boolean disponivel, String placa, String marca, String modelo, Integer anoFabricacao, Double capacidade, Double custoPorDia, CategoriaVeiculo categoriaVeiculo, Integer numeroDeEixos) {
        super(id, disponivel, placa, marca, modelo, anoFabricacao, capacidade, custoPorDia, categoriaVeiculo);
        this.numeroDeEixos = numeroDeEixos;
    }

    public Integer getNumeroDeEixos() {
        return numeroDeEixos;
    }

    public void setNumeroDeEixos(Integer numeroDeEixos) {
        this.numeroDeEixos = numeroDeEixos;
    }
}
