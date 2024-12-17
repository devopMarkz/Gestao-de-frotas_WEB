package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Motorista findByCnh(String cnh);

}
