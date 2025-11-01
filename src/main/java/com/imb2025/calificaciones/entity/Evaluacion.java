package com.imb2025.calificaciones.entity;

import jakarta.persistence.ManyToOne;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Evaluacion extends BaseEntity {

	private Date fecha;

	@ManyToOne
	private TipoEvaluacion tipoEvaluacion;

	@ManyToOne
	private Materia materia;

	@ManyToOne
	private Comision comision;

	public Evaluacion() {
		super();
	}

	public Evaluacion(Date fecha, TipoEvaluacion tipoEvaluacion, Materia materia, Comision comision) {
		this.fecha = fecha;
		this.tipoEvaluacion = tipoEvaluacion;
		this.materia = materia;
		this.comision = comision;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TipoEvaluacion getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
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
