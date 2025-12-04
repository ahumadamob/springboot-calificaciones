package com.imb2025.calificaciones.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class PeriodoLectivoRequestDto {

	@NotBlank(message = "El nombre no puede estar vacio.")
    private String nombre;
	
	@PastOrPresent(message = "La fecha debe ser pasada o actual.")
    private LocalDate fechaInicio;
	
	@FutureOrPresent(message = "La fecha debe ser futura o actual.")
    private LocalDate fechaFin;
	
	@NotNull(message = "La descripcion no debe ser nula.")
	@Size(min = 5, message = "La descripcion debe ser más larga que 5 caracteres.")
	private String descripcionCorta;

    public PeriodoLectivoRequestDto() {
    }

    public PeriodoLectivoRequestDto(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String descripcionCorta) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcionCorta = descripcionCorta;
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

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	
}
