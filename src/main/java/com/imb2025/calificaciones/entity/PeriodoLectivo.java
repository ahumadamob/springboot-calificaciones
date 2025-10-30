package com.imb2025.calificaciones.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class PeriodoLectivo extends BaseEntity {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public PeriodoLectivo() {}

	public PeriodoLectivo(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
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
