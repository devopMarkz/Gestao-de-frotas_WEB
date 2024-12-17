package com.marcos.gestao_de_frota.controllers.handlers;

import com.marcos.gestao_de_frota.dto.ErrorMessageDto;
import com.marcos.gestao_de_frota.services.exceptions.MotoristaInexistenteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MotoristaInexistenteException.class)
    public ResponseEntity<ErrorMessageDto> motoristaInexistente(MotoristaInexistenteException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

}
