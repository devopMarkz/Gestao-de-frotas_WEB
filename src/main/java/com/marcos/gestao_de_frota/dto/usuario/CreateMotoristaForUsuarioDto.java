package com.marcos.gestao_de_frota.dto.usuario;

import com.marcos.gestao_de_frota.dto.motorista.CreateMotoristaDto;
import com.marcos.gestao_de_frota.dto.motorista.MotoristaDto;
import jakarta.validation.constraints.Email;

public class CreateMotoristaForUsuarioDto {

    @Email(message = "Formato de e-mail inválido.")
    private String email;

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
