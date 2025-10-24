package com.imb2025.calificaciones.dto.request;

import com.imb2025.calificaciones.entity.CalendarioMateria;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class CalendarioMateriaRequestDto {

    @NotNull(message = "La fecha de inicio es obligatoria")
    @PastOrPresent(message = "La fecha de inicio no puede ser futura")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    @Future(message = "La fecha de fin debe ser futura")
    private LocalDate fechaFin;

    @NotNull(message = "El ID de la materia es obligatorio")
    @Positive(message = "El ID de la materia debe ser un número positivo")
    private Long materiaId;

    @NotNull(message = "El ID de la comisión es obligatorio")
    @Positive(message = "El ID de la comisión debe ser un número positivo")
    private Long comisionId;

    private CalendarioMateria.EstadoCalendarioMateria estado;

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
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

    public CalendarioMateria.EstadoCalendarioMateria getEstado() {
        return estado;
    }

    public void setEstado(CalendarioMateria.EstadoCalendarioMateria estado) {
        this.estado = estado;
    }
}
