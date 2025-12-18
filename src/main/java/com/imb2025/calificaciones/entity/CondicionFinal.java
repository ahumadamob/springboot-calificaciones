package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;

@Entity
public class CondicionFinal extends BaseEntity {

    private String nombre;
    
    private String descripcionCorta;

    public CondicionFinal() {}

    public CondicionFinal(String nombre, String descripcionCorta) {
        this.nombre = nombre;
        this.descripcionCorta = descripcionCorta;
    }
    
    
    public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
