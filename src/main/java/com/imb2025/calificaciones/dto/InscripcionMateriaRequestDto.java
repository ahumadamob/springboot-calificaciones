package com.imb2025.calificaciones.dto;

public class InscripcionMateriaRequestDto {

    private Long alumnoId;
    private Long materiaId;
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
