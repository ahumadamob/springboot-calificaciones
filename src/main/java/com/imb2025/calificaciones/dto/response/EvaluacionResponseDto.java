package com.imb2025.calificaciones.dto.response;

import java.util.Date;

import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Evaluacion;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.TipoEvaluacion;

public class EvaluacionResponseDto {

	private Long id;

	private Date fecha;

	private TipoEvaluacion tipoEvaluacion;

	private Materia materia;

	private Comision comision;

	private Long version;

	private Evaluacion.Estado estado;

	public Long total;

	public EvaluacionResponseDto() {
	}

	public EvaluacionResponseDto(Long id, Date fecha, TipoEvaluacion tipoEvaluacion, Materia materia,
			Comision comision, Long version) {
		this.id = id;
		this.fecha = fecha;
		this.tipoEvaluacion = tipoEvaluacion;
		this.materia = materia;
		this.comision = comision;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Evaluacion.Estado getEstado() {
		return estado;
	}

	public void setEstado(Evaluacion.Estado estado) {
		this.estado = estado;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
