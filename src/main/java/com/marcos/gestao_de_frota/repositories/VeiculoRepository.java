package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
