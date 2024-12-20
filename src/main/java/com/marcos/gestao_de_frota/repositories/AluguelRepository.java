package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Aluguel;
import com.marcos.gestao_de_frota.entities.VeiculoMotoristaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, VeiculoMotoristaPK> {



}
