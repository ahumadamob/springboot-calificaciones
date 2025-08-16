package com.imb2025.calificaciones.entity;

import jakarta.persistence.ManyToOne;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evaluacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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

        public Evaluacion(Long id, Date fecha, TipoEvaluacion tipoEvaluacion, Materia materia, Comision comision) {
                this.id = id;
                this.fecha = fecha;
                this.tipoEvaluacion = tipoEvaluacion;
                this.materia = materia;
                this.comision = comision;
        }

        public Evaluacion(Date fecha, TipoEvaluacion tipoEvaluacion, Materia materia, Comision comision) {
                this.fecha = fecha;
                this.tipoEvaluacion = tipoEvaluacion;
                this.materia = materia;
                this.comision = comision;
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
}
