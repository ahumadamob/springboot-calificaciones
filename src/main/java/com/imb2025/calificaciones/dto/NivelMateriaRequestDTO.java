package com.imb2025.calificaciones.dto;

public class NivelMateriaRequestDTO {
	private String nombre;
    private Long nivelId;    // ID de la entidad Nivel relacionada
    private Long materiaId;  // ID de la entidad Materia relacionada
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getNivelId() {
		return nivelId;
	}
	public void setNivelId(Long nivelId) {
		this.nivelId = nivelId;
	}
	public Long getMateriaId() {
		return materiaId;
	}
	public void setMateriaId(Long materiaId) {
		this.materiaId = materiaId;
	}
	
	

}
