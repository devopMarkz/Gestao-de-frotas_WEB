package com.marcos.gestao_de_frota.dto.aluguel;

import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDateTime;

public class CreateAluguelDto {

    private String cnh;
    private String placa;

    @FutureOrPresent(message = "A data inicial do aluguel não pode ser retroativa.")
    private LocalDateTime dataHoraInicio;

    @FutureOrPresent(message = "A data final do aluguel não pode ser retroativa.")
    private LocalDateTime dataHoraFim;

    public CreateAluguelDto(String cnh, String placa, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        this.cnh = cnh;
        this.placa = placa;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
    }

    public String getCnh() {
        return cnh;
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }
}
