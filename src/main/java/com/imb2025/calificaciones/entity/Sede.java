package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;

@Entity
public class Sede extends BaseEntity {

    private String nombre;
    private String direccion;

    public Sede() {
    }

    public Sede(Long id, String nombre, String direccion) {
        this.setId(id);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Sede(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

