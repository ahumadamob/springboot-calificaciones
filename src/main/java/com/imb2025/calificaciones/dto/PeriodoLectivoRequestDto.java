package com.imb2025.calificaciones.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class PeriodoLectivoRequestDto {

	@NotBlank(message = "El nombre no puede estar vacio.")
    private String nombre;
	
	@PastOrPresent(message = "La fecha debe ser pasada o actual.")
    private LocalDate fechaInicio;
	
	@FutureOrPresent(message = "La fecha debe ser futura o actual.")
    private LocalDate fechaFin;

    public PeriodoLectivoRequestDto() {
    }

    public PeriodoLectivoRequestDto(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
}
