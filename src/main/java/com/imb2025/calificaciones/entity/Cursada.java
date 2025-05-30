package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cursada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private Long alumnoId;
	private Long materiaId;
	private Long anioLectivoId;
	private Long condicionFinalId;
	
	
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
	public Long getMateriaId() {
		return materiaId;
	}
	public void setMateriaId(Long materiaId) {
		this.materiaId = materiaId;
	}
	public Long getAnioLectivoId() {
		return anioLectivoId;
	}
	public void setAnioLectivoId(Long anioLectivoId) {
		this.anioLectivoId = anioLectivoId;
	}
	public Long getCondicionFinalId() {
		return condicionFinalId;
	}
	public void setCondicionFinalId(Long condicionFinalId) {
		this.condicionFinalId = condicionFinalId;
	}
	
	

}
