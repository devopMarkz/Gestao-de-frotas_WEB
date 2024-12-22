package com.marcos.gestao_de_frota.repositories;

import com.marcos.gestao_de_frota.entities.Motorista;
import com.marcos.gestao_de_frota.projections.UsuarioEmailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Optional<Motorista> findByCnh(String cnh);

    @Query(nativeQuery = true,
            value = "SELECT usuario.email " +
                    "FROM tb_motorista AS motorista " +
                    "INNER JOIN tb_usuario AS usuario " +
                    "ON motorista.id = usuario.motorista_id " +
                    "WHERE motorista.cnh = :cnh")
    UsuarioEmailProjection searchDriveUserEmailByCnh(String cnh);

}
