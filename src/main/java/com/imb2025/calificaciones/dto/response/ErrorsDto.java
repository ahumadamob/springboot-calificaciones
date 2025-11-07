package com.imb2025.calificaciones.dto.response;

import java.util.List;

public class ErrorsDto {
	private List<String> errors;

    public ErrorsDto() {
    }

    public ErrorsDto(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
