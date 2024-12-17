package com.marcos.gestao_de_frota.services.exceptions;

public class MotoristaInexistenteException extends RuntimeException {
    public MotoristaInexistenteException(String message) {
        super(message);
    }
}
