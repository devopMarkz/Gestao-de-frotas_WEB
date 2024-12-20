package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT obj FROM Usuario obj JOIN FETCH obj.motorista WHERE obj.email = :email AND obj.password = :password")
    Optional<Usuario> findByEmailAndPassword(String email, String password);

    Optional<Usuario> findByEmail(String email);

}
