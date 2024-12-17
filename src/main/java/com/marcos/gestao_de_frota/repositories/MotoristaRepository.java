package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
}
