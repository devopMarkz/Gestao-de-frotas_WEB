package com.marcos.gestao_de_frota.services.exceptions;

public class PlacaDeVeiculoJaExistenteException extends RuntimeException {
    public PlacaDeVeiculoJaExistenteException(String message) {
        super(message);
    }
}
