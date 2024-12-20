package com.marcos.gestao_de_frota.entities.enums;

public enum StatusAluguel {
    PENDENTE,
    EM_ANDAMENTO,
    FINALIZADO,
    CANCELADO;

    public boolean isFinalizado() {
        return this == FINALIZADO;
    }
    public boolean isEmAndamento() {
        return this == EM_ANDAMENTO;
    }
}
