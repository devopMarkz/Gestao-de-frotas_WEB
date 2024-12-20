package com.marcos.gestao_de_frota.dto.usuario;

import com.marcos.gestao_de_frota.dto.motorista.MotoristaDto;
import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.entities.enums.TipoDeUsuario;
import jakarta.persistence.*;

public class UsuarioDto {

    private String email;
    private String password;
    private String tipoDeUsuario;
    private MotoristaDto cadastroDeMotorista;

    public UsuarioDto(String email, String password, String tipoDeUsuario, MotoristaDto cadastroDeMotorista) {
        this.email = email;
        this.password = password;
        this.tipoDeUsuario = tipoDeUsuario;
        this.cadastroDeMotorista = cadastroDeMotorista;
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

    public MotoristaDto getCadastroDeMotorista() {
        return cadastroDeMotorista;
    }
}
