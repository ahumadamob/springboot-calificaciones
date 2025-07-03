package com.imb2025.calificaciones.dto;

import jakarta.validation.constraints.NotNull;

public class RequisitoMateriaRequestDTO {

    @NotNull(message = "El ID de la materia es obligatorio")
    private Long materiaId;

    @NotNull(message = "El ID de la materia requerida es obligatorio")
    private Long materiaRequeridaId;

    // Getters y Setters
    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Long getMateriaRequeridaId() {
        return materiaRequeridaId;
    }

    public void setMateriaRequeridaId(Long materiaRequeridaId) {
        this.materiaRequeridaId = materiaRequeridaId;
    }
}

