package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
