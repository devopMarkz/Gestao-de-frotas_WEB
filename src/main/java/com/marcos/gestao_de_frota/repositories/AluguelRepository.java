package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Aluguel;
import com.marcos.gestao_de_frota.entities.VeiculoMotoristaPK;
import com.marcos.gestao_de_frota.entities.enums.StatusAluguel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface AluguelRepository extends JpaRepository<Aluguel, VeiculoMotoristaPK> {

    @Query("SELECT obj FROM Aluguel obj WHERE obj.dataHoraFim >= :startDate AND obj.dataHoraFim <= :endDate AND obj.statusAluguel = :statusAluguel")
    Page<Aluguel> searchByFilters(LocalDateTime startDate, LocalDateTime endDate, StatusAluguel statusAluguel, Pageable pageable);

}
