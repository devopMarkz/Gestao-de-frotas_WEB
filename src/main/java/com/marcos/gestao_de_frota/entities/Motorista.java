package com.marcos.gestao_de_frota.entities;

import com.marcos.gestao_de_frota.entities.enums.CategoriaCNH;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_motoristas")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Boolean disponivel;

    @Column(unique = true)
    private String cnh;

    @Enumerated(EnumType.STRING)
    private CategoriaCNH categoriaCNH;

    private LocalDate dataNascimento;

    public Motorista() {
    }

    public Motorista(Long id, String nome, Boolean disponivel, String cnh, CategoriaCNH categoriaCNH, LocalDate dataNascimento) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public CategoriaCNH getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(CategoriaCNH categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Motorista motorista = (Motorista) object;
        return Objects.equals(id, motorista.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
