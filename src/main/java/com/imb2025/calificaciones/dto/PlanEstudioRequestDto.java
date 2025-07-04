package com.imb2025.calificaciones.dto;

public class PlanEstudioRequestDto {

	private Long id;
	private Long carreraId;
	private String nombre;
	private Long aniovigencia;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCarreraId() {
		return carreraId;
	}
	public void setCarreraId(Long carreraId) {
		this.carreraId = carreraId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getAniovigencia() {
		return aniovigencia;
	}
	public void setAniovigencia(Long aniovigencia) {
		this.aniovigencia = aniovigencia;
	}
	
}
