package com.imb2025.calificaciones.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegistroClase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fecha_clase",nullable = false)
	private LocalDate fecha;
	@Column(name="tema_materia",nullable = false)
	private String tema;
	
	@Column(name = "docente_id",nullable = false)
    private Long docenteId;

    @Column(name = "comision_id",nullable = false)
    private Long comisionId;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Long getDocenteId() {
		return docenteId;
	}

	public void setDocenteId(Long docenteId) {
		this.docenteId = docenteId;
	}

	public Long getComisionId() {
		return comisionId;
	}

	public void setComisionId(Long comisionId) {
		this.comisionId = comisionId;
	}

	public Long getId() {
		return id;
	}
    
    

}
