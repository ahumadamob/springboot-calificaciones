package com.imb2025.calificaciones.dto;

import java.time.LocalDate;

public class PeriodoLectivoRequestDTO {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	public PeriodoLectivoRequestDTO() {}
	
	public PeriodoLectivoRequestDTO(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
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
