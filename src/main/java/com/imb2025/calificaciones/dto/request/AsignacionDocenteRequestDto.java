package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AsignacionDocenteRequestDto {

    @NotNull(message = "El ID del docente es obligatorio")
    @Positive(message = "El ID del docente debe ser un número positivo")
    private Long docenteId;

    @NotNull(message = "El ID de la materia es obligatorio")
    @Positive(message = "El ID de la materia debe ser un número positivo")
    private Long materiaId;

    @NotNull(message = "El ID de la comisión es obligatorio")
    @Positive(message = "El ID de la comisión debe ser un número positivo")
    private Long comisionId;

    @NotNull(message = "El ID del período lectivo es obligatorio")
    @Positive(message = "El ID del período lectivo debe ser un número positivo")
    private Long periodoLectivoId;

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
