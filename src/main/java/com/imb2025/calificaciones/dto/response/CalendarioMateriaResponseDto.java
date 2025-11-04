package com.imb2025.calificaciones.dto.response;

import java.time.LocalDate;

public class CalendarioMateriaResponseDto {
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long materia;
    private Long comision;
    private Long version;

    public CalendarioMateriaResponseDto(Long id, Long version, Long comision, Long materia, LocalDate fechaFin, LocalDate fechaInicio) {
        this.id = id;
        this.version = version;
        this.comision = comision;
        this.materia = materia;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
    }

    public CalendarioMateriaResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getComision() {
        return comision;
    }

    public void setComision(Long comision) {
        this.comision = comision;
    }

    public Long getMateria() {
        return materia;
    }

    public void setMateria(Long materia) {
        this.materia = materia;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
