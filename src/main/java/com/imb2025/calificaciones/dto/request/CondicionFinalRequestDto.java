package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CondicionFinalRequestDto {

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    public CondicionFinalRequestDto() {
    }

    public CondicionFinalRequestDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
