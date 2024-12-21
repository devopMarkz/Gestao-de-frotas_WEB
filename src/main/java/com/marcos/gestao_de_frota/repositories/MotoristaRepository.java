package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Optional<Motorista> findByCnh(String cnh);

}
