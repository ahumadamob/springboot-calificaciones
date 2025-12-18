package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
@Entity
public class TipoNota extends BaseEntity {

    private String nombre;
    private String descripcion;
    private String descripcionCorta;

    
    public TipoNota() {}

    public TipoNota(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        //this.descripcionCorta = descripcionCorta;
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

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
    
    
}