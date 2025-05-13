package com.imb2025.calificaciones.entity;

import java.time.LocalTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PeriodoLectivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private LocalTime fechaInicio;
	private LocalTime fechaFin;
	
	public PeriodoLectivo(Long id, String nombre, LocalTime fechaInicio, LocalTime fechaFin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalTime fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
