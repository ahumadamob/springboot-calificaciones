package com.imb2025.calificaciones.dto.response;

import com.imb2025.calificaciones.entity.TipoEvaluacionEnum;

public class TipoEvaluacionResponseDto {
	
	private Long id;
    private String nombre;
    private String descripcion;
    private Long version;
    private TipoEvaluacionEnum categoria;

    //Getter and Setters
    
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public TipoEvaluacionEnum getCategoria() {
		return categoria;
	}
	public void setCategoria(TipoEvaluacionEnum categoria) {
		this.categoria = categoria;
	}    
}
