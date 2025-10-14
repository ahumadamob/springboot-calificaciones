package com.imb2025.calificaciones.dto.response;

import java.time.LocalDate;

public class PeriodoLectivoResponseDto {
	private Long id;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
    private Long version;
    
    public PeriodoLectivoResponseDto() {
    }
    
	public PeriodoLectivoResponseDto(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, Long version) {
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.version = version;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public Long getVersion() {
		return version;
	}
	
	public void setVersion(Long version) {
		this.version = version;
	}
    
}
