package com.marcos.gestao_de_frota.services.exceptions;

public class VeiculoInexistenteException extends RuntimeException {
    public VeiculoInexistenteException(String message) {
        super(message);
    }
}
