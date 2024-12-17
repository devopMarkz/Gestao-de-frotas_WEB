package com.marcos.gestao_de_frota.controllers.handlers;

import com.marcos.gestao_de_frota.dto.ErrorFieldsDto;
import com.marcos.gestao_de_frota.dto.ErrorMessageDto;
import com.marcos.gestao_de_frota.dto.ErrorMessageFieldsDto;
import com.marcos.gestao_de_frota.services.exceptions.MotoristaInexistenteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MotoristaInexistenteException.class)
    public ResponseEntity<ErrorMessageDto> motoristaInexistente(MotoristaInexistenteException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessageDto> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageFieldsDto errorMessageDto = new ErrorMessageFieldsDto(Instant.now(), status.value(), "Erro no processamento de dados.", request.getRequestURI());
        for (FieldError error : e.getFieldErrors()){
            String field = error.getField();
            String message = error.getDefaultMessage();
            ErrorFieldsDto errorFieldsDto = new ErrorFieldsDto(field, message);
            errorMessageDto.getErrors().add(errorFieldsDto);
        }
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

}
