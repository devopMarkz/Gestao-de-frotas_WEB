package com.marcos.gestao_de_frota.dto.aluguel;

import com.marcos.gestao_de_frota.dto.motorista.MotoristaDto;
import com.marcos.gestao_de_frota.dto.veiculo.VeiculoDto;
import com.marcos.gestao_de_frota.entities.enums.StatusAluguel;

import java.time.LocalDateTime;

public class AluguelDto {

    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private StatusAluguel statusAluguel;
    private Double valorAluguel;
    private MotoristaDto motorista;
    private VeiculoDto veiculo;

    public AluguelDto(MotoristaDto motorista, VeiculoDto veiculo, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, StatusAluguel statusAluguel, Double valorAluguel) {
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.statusAluguel = statusAluguel;
        this.valorAluguel = valorAluguel;
        this.motorista = motorista;
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public StatusAluguel getStatusAluguel() {
        return statusAluguel;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public MotoristaDto getMotorista() {
        return motorista;
    }

    public VeiculoDto getVeiculo() {
        return veiculo;
    }
}
