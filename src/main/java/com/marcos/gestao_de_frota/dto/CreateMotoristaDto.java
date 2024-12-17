package com.marcos.gestao_de_frota.dto;

import com.marcos.gestao_de_frota.entities.enums.CategoriaCNH;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateMotoristaDto {

    private Boolean disponivel = true;

    @Size(min = 9, max = 9, message = "A CNH deve conter 9 dígitos")
    private String cnh;

    @Pattern(regexp = "^[A-E]$", message = "A categoria deve ser uma letra maiúscula de A a E")
    private String categoriaCNH;

    @Past
    private LocalDate dataNascimento;

    public CreateMotoristaDto(String cnh, String categoriaCNH, LocalDate dataNascimento) {
        this.cnh = cnh;
        this.categoriaCNH = categoriaCNH;
        this.dataNascimento = dataNascimento;
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
