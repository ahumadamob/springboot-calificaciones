package com.imb2025.calificaciones.dto;

import jakarta.validation.constraints.NotNull;

public class AsignacionDocenteRequestDTO {
    private Long id;

    @NotNull(message = "El ID del docente es obligatorio")
    private Long docenteId;

    @NotNull(message = "El ID de la materia es obligatorio")
    private Long materiaId;

    @NotNull(message = "El ID de la comisión es obligatorio")
    private Long comisionId;

    @NotNull(message = "El ID del período lectivo es obligatorio")
    private Long periodoLectivoId;

    public AsignacionDocenteRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Long getComisionId() {
        return comisionId;
    }

    public void setComisionId(Long comisionId) {
        this.comisionId = comisionId;
    }

    public Long getPeriodoLectivoId() {
        return periodoLectivoId;
    }

    public void setPeriodoLectivoId(Long periodoLectivoId) {
        this.periodoLectivoId = periodoLectivoId;
    }
}