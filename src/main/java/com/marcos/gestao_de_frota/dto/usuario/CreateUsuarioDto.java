package com.marcos.gestao_de_frota.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateUsuarioDto {

    @Email(message = "Formato de e-mail inválido.")
    private String email;

    @Size(min = 8, message = "Senha precisa conter no mínimo 8 dígitos.")
    private String password;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "O campo deve conter apenas letras.")
    private String tipoDeUsuario;

    public CreateUsuarioDto(String email, String password, String tipoDeUsuario) {
        this.email = email;
        this.password = password;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }
}
