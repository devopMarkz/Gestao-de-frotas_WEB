package com.marcos.gestao_de_frota.services.exceptions;

public class EmailJaExistenteException extends RuntimeException {
    public EmailJaExistenteException(String message) {
        super(message);
    }
}
