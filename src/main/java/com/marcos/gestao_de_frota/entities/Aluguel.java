package com.marcos.gestao_de_frota.entities;

import com.marcos.gestao_de_frota.entities.enums.StatusAluguel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "tb_aluguel")
public class Aluguel {

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

    @Enumerated(EnumType.STRING)
    @Column(name = "status_aluguel")
    private StatusAluguel statusAluguel;

    @Column(name = "valor_aluguel")
    private Double valorAluguel;

    public Aluguel() {
    }

    public Aluguel(Motorista motorista, Veiculo veiculo, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, StatusAluguel statusAluguel) {
        this.id.setMotoristaId(motorista.getId());
        this.id.setVeiculoId(veiculo.getId());
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.statusAluguel = statusAluguel;
    }

    public VeiculoMotoristaPK getId() {
        return id;
    }

    public void setId(VeiculoMotoristaPK id) {
        this.id = id;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public StatusAluguel getStatusAluguel() {
        return statusAluguel;
    }

    public void setStatusAluguel(StatusAluguel statusAluguel) {
        this.statusAluguel = statusAluguel;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public void calcularValorAluguel() {
        if (this.dataHoraFim != null) {
            long diasAluguel = java.time.temporal.ChronoUnit.DAYS.between(dataHoraInicio, dataHoraFim);
            double custoBase = veiculo.getCustoPorDia() * diasAluguel;
            this.valorAluguel = custoBase;
        }
    }

    public void iniciarAluguel() {
        this.statusAluguel = StatusAluguel.EM_ANDAMENTO;
    }

    public void finalizarAluguel() {
        this.statusAluguel = StatusAluguel.FINALIZADO;
        calcularValorAluguel();
    }

    public void cancelarAluguel() {
        this.statusAluguel = StatusAluguel.CANCELADO;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Aluguel aluguel = (Aluguel) object;
        return Objects.equals(id, aluguel.id) && Objects.equals(motorista, aluguel.motorista) && Objects.equals(veiculo, aluguel.veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, motorista, veiculo);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Início: " + dataHoraInicio.format(formatter)
                + " - Fim: " + dataHoraFim.format(formatter)
                + " - Valor: R$" + String.format("%.2f", valorAluguel);
    }
}
