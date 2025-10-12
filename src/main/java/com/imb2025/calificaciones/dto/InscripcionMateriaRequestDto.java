package com.imb2025.calificaciones.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InscripcionMateriaRequestDto {
    @NotNull(message ="El id del alumno no puede estar vacío")
    @Min(1)
    private Long alumnoId;
    @NotNull(message = "El id de la materia no puede estar vacío")
    @Min(1)
    private Long materiaId;
    @NotNull(message = "el id del periodo electivo no puede estar vacío")
    @Min(1)
    private Long periodoLectivoId;

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Long getPeriodoLectivoId() {
        return periodoLectivoId;
    }

    public void setPeriodoLectivoId(Long periodoLectivoId) {
        this.periodoLectivoId = periodoLectivoId;
    }
}
