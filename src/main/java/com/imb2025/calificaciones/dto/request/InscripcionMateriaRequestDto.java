package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.Positive;

public class InscripcionMateriaRequestDto {
    @Positive(message = "Debe ingresar un id positivo de alumno")
    private Long alumnoId;
    @Positive(message = "Debe ingresar un id positivo de materia")
    private Long materiaId;
    @Positive(message = "Debe ingresar un id positivo de periodo")
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
