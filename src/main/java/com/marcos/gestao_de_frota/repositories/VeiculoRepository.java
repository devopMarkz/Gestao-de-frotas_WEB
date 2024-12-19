package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.dto.veiculo.VeiculoDto;
import com.marcos.gestao_de_frota.entities.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("SELECT obj FROM Veiculo obj " +
            "WHERE obj.disponivel = :disponivel " +
            "AND UPPER(obj.categoriaVeiculo) = UPPER(:categoriaVeiculo)")
    Page<Veiculo> searchAll(@Param("disponivel") Boolean disponivel,
                            @Param("categoriaVeiculo") String categoriaVeiculo,
                            Pageable pageable);

    Page<Veiculo> findByDisponivel(@Param("disponivel") Boolean disponivel, Pageable pageable);

}
