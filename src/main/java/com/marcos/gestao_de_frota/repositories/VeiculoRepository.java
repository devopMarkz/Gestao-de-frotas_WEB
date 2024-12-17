package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
