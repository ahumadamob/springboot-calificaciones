package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;

@Entity
public class CondicionFinal extends BaseEntity {

    private String nombre;

    public CondicionFinal() {}

    public CondicionFinal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
