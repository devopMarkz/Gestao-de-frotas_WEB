package com.marcos.gestao_de_frota.dto;

import com.marcos.gestao_de_frota.entities.enums.CategoriaCNH;

import java.time.LocalDate;

public class MotoristaDto {

    private Long id;
    private String nome;
    private Boolean disponivel;
    private String cnh;
    private CategoriaCNH categoriaCNH;
    private LocalDate dataNascimento;

    public MotoristaDto(Long id, String nome, Boolean disponivel, String cnh, CategoriaCNH categoriaCNH, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.disponivel = disponivel;
        this.cnh = cnh;
        this.categoriaCNH = categoriaCNH;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public String getCnh() {
        return cnh;
    }

    public CategoriaCNH getCategoriaCNH() {
        return categoriaCNH;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
