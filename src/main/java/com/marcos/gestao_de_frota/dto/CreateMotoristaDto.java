package com.marcos.gestao_de_frota.dto;

import com.marcos.gestao_de_frota.entities.enums.CategoriaCNH;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateMotoristaDto {

    private String nome;
    private Boolean disponivel = true;

    @Size(min = 9, max = 9, message = "A CNH deve conter 9 dígitos")
    private String cnh;

    @Pattern(regexp = "^[A-E]$", message = "A categoria deve ser uma letra maiúscula de A a E")
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
