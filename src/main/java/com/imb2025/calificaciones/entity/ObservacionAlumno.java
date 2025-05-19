package com.imb2025.calificaciones.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "observacion_alumno")
public class ObservacionAlumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
    private Long alumnoId;
    private Long docenteId;
    private String texto;
    private Date fecha;
    
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAlumnoId() {
		return alumnoId;
	}
	
	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}
	
	public Long getDocenteId() {
		return docenteId;
	}
	
	public void setDocenteId(Long docenteId) {
		this.docenteId = docenteId;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
