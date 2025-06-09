package com.imb2025.calificaciones.condicionfinal.dto;

public class CondicionFinalRequestDTO {
    private String nombre;

    public CondicionFinalRequestDTO() {
    }

    public CondicionFinalRequestDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
