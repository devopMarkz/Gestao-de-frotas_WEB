package com.marcos.gestao_de_frota.entities;

import com.marcos.gestao_de_frota.entities.enums.TipoDeUsuario;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipoDeUsuario;

    @OneToOne
    @JoinColumn(name = "motorista_id", referencedColumnName = "id", unique = true)
    private Motorista motorista;

    public Usuario(){
    }

    public Usuario(Long id, String email, String password, TipoDeUsuario tipoDeUsuario, Motorista motorista) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.tipoDeUsuario = tipoDeUsuario;
        this.motorista = motorista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoDeUsuario getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Usuario usuario = (Usuario) object;
        return Objects.equals(id, usuario.id) && Objects.equals(email, usuario.email) && Objects.equals(password, usuario.password) && Objects.equals(motorista, usuario.motorista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}
