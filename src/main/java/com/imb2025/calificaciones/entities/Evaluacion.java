package com.imb2025.calificaciones.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evaluacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date fechaEvaluacion;
	
	private int tipoEvaluacionId;
	
	private int materiaId;
	
	private int comisionId;

	
	
	public Evaluacion() {
		super();
	}

	public Evaluacion(int id, Date fechaEvaluacion, int tipoEvaluacionId, int materiaId, int comisionId) {
		super();
		this.id = id;
		this.fechaEvaluacion = fechaEvaluacion;
		this.tipoEvaluacionId = tipoEvaluacionId;
		this.materiaId = materiaId;
		this.comisionId = comisionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public int getTipoEvaluacionId() {
		return tipoEvaluacionId;
	}

	public void setTipoEvaluacionId(int tipoEvaluacionId) {
		this.tipoEvaluacionId = tipoEvaluacionId;
	}

	public int getMateriaId() {
		return materiaId;
	}

	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}

	public int getComisionId() {
		return comisionId;
	}

	public void setComisionId(int comisionId) {
		this.comisionId = comisionId;
	}
	
	
	
}
