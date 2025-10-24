package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;

@Entity
public class Sede extends BaseEntity {

    private String nombre;
    private String direccion;

    private Boolean activa = Boolean.TRUE;

    public Sede() {
    }

    public Sede(Long id, String nombre, String direccion, Boolean activa) {
        this.setId(id);
        this.nombre = nombre;
        this.direccion = direccion;
        this.activa = activa;
    }

    public Sede(String nombre, String direccion, Boolean activa) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.activa = activa;
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

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}

