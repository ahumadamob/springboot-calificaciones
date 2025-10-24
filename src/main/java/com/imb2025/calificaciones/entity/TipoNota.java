package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
@Entity
public class TipoNota extends BaseEntity {

    private String nombre;
    private String descripcion;
    private boolean activo;

    
    public TipoNota() {}

    public TipoNota(String nombre, String descripcion, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo=activo;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
    
    
}