package com.marcos.gestao_de_frota.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CreateMotoristaDto {

    @NotBlank(message = "O campo nome não pode estar nulo ou vazio.")
    private String nome;

    private Boolean disponivel = true;

    @Size(min = 9, max = 9, message = "A CNH deve conter 9 dígitos.")
    @NotBlank(message = "O campo cnh não pode estar nulo ou vazio.")
    private String cnh;

    @Pattern(regexp = "^[A-E]$", message = "A categoria deve ser uma letra maiúscula de A a E.")
    @NotBlank(message = "O campo categoriaCNH não pode estar nulo ou vazio.")
    private String categoriaCNH;

    @Past(message = "A data de nascimento deve ser retroativa.")
    private LocalDate dataNascimento;

    public CreateMotoristaDto(String nome, String cnh, String categoriaCNH, LocalDate dataNascimento) {
        this.nome = nome;
        this.cnh = cnh;
        this.categoriaCNH = categoriaCNH;
        this.dataNascimento = dataNascimento;
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

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
