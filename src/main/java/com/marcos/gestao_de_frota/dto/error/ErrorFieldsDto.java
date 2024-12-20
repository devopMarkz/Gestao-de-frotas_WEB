package com.marcos.gestao_de_frota.dto.error;

public class ErrorFieldsDto {

    private String field;
    private String message;

    public ErrorFieldsDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
