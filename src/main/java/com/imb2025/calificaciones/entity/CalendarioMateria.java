package com.imb2025.calificaciones.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name= "calendario_materia")
public class CalendarioMateria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="fecha_inicio")
	private LocalDate fechaInicio;
	@Column(name="fecha_fin")
	private LocalDate fechaFin;

	@ManyToOne
	@JoinColumn(name = "materia_id")
	private Materia materia;

	@ManyToOne
	@JoinColumn(name = "comision_id")
	private Comision comision;

	// GETTERS & SETTERS
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}
}
