package com.marcos.gestao_de_frota.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean disponivel;

}
