package com.marcos.gestao_de_frota.controllers.handlers;

import com.marcos.gestao_de_frota.dto.error.ErrorFieldsDto;
import com.marcos.gestao_de_frota.dto.error.ErrorMessageDto;
import com.marcos.gestao_de_frota.dto.error.ErrorMessageFieldsDto;
import com.marcos.gestao_de_frota.services.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(MotoristaJaExistenteException.class)
    public ResponseEntity<ErrorMessageDto> motoristaJaExistente(MotoristaJaExistenteException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(VeiculoInvalidoException.class)
    public ResponseEntity<ErrorMessageDto> veiculoInvalido(VeiculoInvalidoException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(VeiculoInexistenteException.class)
    public ResponseEntity<ErrorMessageDto> veiculoInexistente(VeiculoInexistenteException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(PlacaDeVeiculoJaExistenteException.class)
    public ResponseEntity<ErrorMessageDto> placaDeVeiculoJaExistente(PlacaDeVeiculoJaExistenteException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(UsuarioInexistenteException.class)
    public ResponseEntity<ErrorMessageDto> usuarioInexistente(UsuarioInexistenteException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(EmailJaExistenteException.class)
    public ResponseEntity<ErrorMessageDto> emailJaExistente(EmailJaExistenteException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(VeiculoIndisponivelException.class)
    public ResponseEntity<ErrorMessageDto> veiculoIndisponivel(VeiculoIndisponivelException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(MotoristaIndisponivelException.class)
    public ResponseEntity<ErrorMessageDto> motoristaIndisponivel(MotoristaIndisponivelException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(DataFimMenorQueDataInicioException.class)
    public ResponseEntity<ErrorMessageDto> dataFimMenorQueDataInicio(DataFimMenorQueDataInicioException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(StatusAluguelInexistente.class)
    public ResponseEntity<ErrorMessageDto> statusAluguelInexistente(StatusAluguelInexistente e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessageDto> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageFieldsDto errorMessageDto = new ErrorMessageFieldsDto(Instant.now(), status.value(), "Erro no processamento de dados.", request.getRequestURI());
        for (FieldError error : e.getFieldErrors()){
            String field = error.getField(); // Atributo da classe Motorista que apresentou inconformidade
            String message = error.getDefaultMessage(); // message definida nas annotations de validação
            ErrorFieldsDto errorFieldsDto = new ErrorFieldsDto(field, message);
            errorMessageDto.getErrors().add(errorFieldsDto);
        }
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessageDto> httpMessageNotReadable(HttpMessageNotReadableException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), "Corpo da requisição inválido.", request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorMessageDto> email(EmailException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(Instant.now(), status.value(), "Corpo da requisição inválido.", request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }
}
