package com.marcos.gestao_de_frota.services.exceptions;

public class StatusAluguelInexistente extends RuntimeException {
    public StatusAluguelInexistente(String message) {
        super(message);
    }
}
