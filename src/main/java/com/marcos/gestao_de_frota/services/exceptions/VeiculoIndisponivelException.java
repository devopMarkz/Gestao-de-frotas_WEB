package com.marcos.gestao_de_frota.services.exceptions;

public class VeiculoIndisponivelException extends RuntimeException {
    public VeiculoIndisponivelException(String message) {
        super(message);
    }
}
