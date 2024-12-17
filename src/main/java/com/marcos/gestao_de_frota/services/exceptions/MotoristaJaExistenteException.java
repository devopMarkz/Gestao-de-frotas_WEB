package com.marcos.gestao_de_frota.services.exceptions;

public class MotoristaJaExistenteException extends RuntimeException {
    public MotoristaJaExistenteException(String message) {
        super(message);
    }
}
