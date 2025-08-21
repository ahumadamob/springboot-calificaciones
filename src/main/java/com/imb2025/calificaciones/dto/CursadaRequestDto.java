package com.imb2025.calificaciones.dto;

public class CursadaRequestDto {

    private Long alumnoId;
    private Long materiaId;
    private Long anioLectivoId;
    private Long condicionFinalId;

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

    public Long getAnioLectivoId() {
        return anioLectivoId;
    }

    public void setAnioLectivoId(Long anioLectivoId) {
        this.anioLectivoId = anioLectivoId;
    }

    public Long getCondicionFinalId() {
        return condicionFinalId;
    }

    public void setCondicionFinalId(Long condicionFinalId) {
        this.condicionFinalId = condicionFinalId;
    }
}
