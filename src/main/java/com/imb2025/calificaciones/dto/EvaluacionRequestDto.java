package com.imb2025.calificaciones.dto;

import java.util.Date;

public class EvaluacionRequestDto {

	private Long id;

	private Date fechaEvaluacion;

	private Long tipoEvaluacionId;

	private Long materiaId;

	private Long comisionId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public Long getTipoEvaluacionId() {
		return tipoEvaluacionId;
	}

	public void setTipoEvaluacionId(Long tipoEvaluacionId) {
		this.tipoEvaluacionId = tipoEvaluacionId;
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
}
