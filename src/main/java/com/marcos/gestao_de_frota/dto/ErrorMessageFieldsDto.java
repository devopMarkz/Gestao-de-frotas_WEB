package com.marcos.gestao_de_frota.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ErrorMessageFieldsDto extends ErrorMessageDto{

    private List<ErrorFieldsDto> errors = new ArrayList<>();

    public ErrorMessageFieldsDto(Instant timestamp, Integer status, String message, String path) {
        super(timestamp, status, message, path);
    }

    public List<ErrorFieldsDto> getErrors() {
        return errors;
    }
}
