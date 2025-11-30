package com.imb2025.calificaciones.dto.response;



public class PlanEstudioResponseDto {
	
	private Long id;
	private String nombre;
	private Long carreraId;
	private Long version;
	
	public PlanEstudioResponseDto() {
    }
    
	public PlanEstudioResponseDto(Long id, String nombre, Long carreraId, Long version) {
		this.id = id;
		this.nombre = nombre;
		this.carreraId = carreraId;
		this.version = version;
	}
	
	
	public Long getID() {
		return id;
	}
	public void setID(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCarreraId() {
		return carreraId;
	}
	public void setCarreraId(Long carreraId) {
		this.carreraId = carreraId;
	}
	
	public Long getVersion() {
		return version;
	}
	
	public void setVersion(Long version) {
		this.version = version;
	}

}
