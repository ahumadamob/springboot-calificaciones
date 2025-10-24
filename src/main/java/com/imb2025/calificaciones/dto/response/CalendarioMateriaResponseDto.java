package com.imb2025.calificaciones.dto.response;

import com.imb2025.calificaciones.entity.CalendarioMateria;

import java.time.LocalDate;

public class CalendarioMateriaResponseDto {
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long materia;
    private Long comision;
    private Long version;
    private CalendarioMateria.EstadoCalendarioMateria estado;

    public CalendarioMateriaResponseDto(Long id, LocalDate fechaInicio, LocalDate fechaFin, Long materia, Long comision, Long version, CalendarioMateria.EstadoCalendarioMateria estado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.materia = materia;
        this.comision = comision;
        this.version = version;
        this.estado = estado;
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

    public CalendarioMateria.EstadoCalendarioMateria getEstado() {
        return estado;
    }

    public void setEstado(CalendarioMateria.EstadoCalendarioMateria estado) {
        this.estado = estado;
    }
}
