package com.imb2025.calificaciones.entity;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "calendario_materia")
public class CalendarioMateria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="materia_id")
	private Long materiaId;
	@Column(name="comision_id")
	private Long comisionId;
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	// GETTERS & SETTERS
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
}
