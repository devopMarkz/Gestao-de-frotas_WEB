package com.marcos.gestao_de_frota.services.exceptions;

public class VeiculoInvalidoException extends RuntimeException {
  public VeiculoInvalidoException(String message) {
    super(message);
  }
}
