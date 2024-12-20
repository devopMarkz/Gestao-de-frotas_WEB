package com.marcos.gestao_de_frota.dto.usuario;

import com.marcos.gestao_de_frota.dto.motorista.CreateMotoristaDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class CreateMotoristaForUsuarioDto {

    @Email(message = "Formato de e-mail inválido.")
    private String email;

    @Valid
    @NotNull(message = "O campo cadastroDeMotorista não pode estar nulo.")
    private CreateMotoristaDto cadastroDeMotorista;

    public CreateMotoristaForUsuarioDto(String email, CreateMotoristaDto cadastroDeMotorista) {
        this.email = email;
        this.cadastroDeMotorista = cadastroDeMotorista;
    }

    public String getEmail() {
        return email;
    }

    public CreateMotoristaDto getCadastroDeMotorista() {
        return cadastroDeMotorista;
    }
}
