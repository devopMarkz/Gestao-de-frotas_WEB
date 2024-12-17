package com.marcos.gestao_de_frota.dto.motorista;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UpdateMotoristaDto {

    @NotNull(message = "O campo id não pode estar nulo.")
    private Long id;

    @NotBlank(message = "O campo nome não pode estar nulo ou vazio.")
    private String nome;

    private Boolean disponivel;

    @Size(min = 9, max = 9, message = "A CNH deve conter 9 dígitos.")
    @NotBlank(message = "O campo cnh não pode estar nulo ou vazio.")
    private String cnh;

    @Pattern(regexp = "^[A-E]$", message = "A categoria deve ser uma letra maiúscula de A a E.")
    @NotBlank(message = "O campo categoriaCNH não pode estar nulo ou vazio.")
    private String categoriaCNH;

    @Past(message = "A data de nascimento deve ser retroativa.")
    private LocalDate dataNascimento;

    public UpdateMotoristaDto(Long id, String nome, Boolean disponivel, String cnh, String categoriaCNH, LocalDate dataNascimento) {
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

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

}
