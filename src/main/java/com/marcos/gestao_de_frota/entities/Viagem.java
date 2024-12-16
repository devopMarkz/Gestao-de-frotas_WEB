package com.marcos.gestao_de_frota.entities;

import com.marcos.gestao_de_frota.entities.enums.StatusViagem;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_viagens")
public class Viagem {

    @EmbeddedId
    private VeiculoMotoristaPK id = new VeiculoMotoristaPK();

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    @MapsId("motoristaId")
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @MapsId("veiculoId")
    private Veiculo veiculo;

    @Column(name = "data_hora_inicio", nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_fim")
    private LocalDateTime dataHoraFim;

    @Column(name = "km_percorrido")
    private Double kmPercorrido;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_viagem")
    private StatusViagem statusViagem;

    public Viagem() {
    }

    public Viagem(Motorista motorista, Veiculo veiculo, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, Double kmPercorrido, StatusViagem statusViagem) {
        this.id.setMotoristaId(motorista.getId());
        this.id.setVeiculoId(veiculo.getId());
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.kmPercorrido = kmPercorrido;
        this.statusViagem = statusViagem;
    }


}
