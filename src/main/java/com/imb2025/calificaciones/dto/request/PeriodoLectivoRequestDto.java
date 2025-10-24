package com.imb2025.calificaciones.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class PeriodoLectivoRequestDto {

	@NotBlank(message = "El nombre no puede estar vacio.")
    private String nombre;
	
	@PastOrPresent(message = "La fecha debe ser pasada o actual.")
    private LocalDate fechaInicio;
	
	@FutureOrPresent(message = "La fecha debe ser futura o actual.")
    private LocalDate fechaFin;
	
	@NotNull(message = "El estado activo del periodo es obligatorio.")
	private boolean activo;

    public PeriodoLectivoRequestDto() {
    }

    public PeriodoLectivoRequestDto(String nombre, LocalDate fechaInicio, LocalDate fechaFin, boolean activo) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activo = activo;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
    
}

