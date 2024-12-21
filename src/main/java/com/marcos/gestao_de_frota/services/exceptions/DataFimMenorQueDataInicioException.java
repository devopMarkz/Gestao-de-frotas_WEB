package com.marcos.gestao_de_frota.services.exceptions;

public class DataFimMenorQueDataInicioException extends RuntimeException {
    public DataFimMenorQueDataInicioException(String message) {
        super(message);
    }
}
