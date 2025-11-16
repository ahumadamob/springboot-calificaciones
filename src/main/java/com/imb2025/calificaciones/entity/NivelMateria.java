package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
public class NivelMateria extends BaseEntity {

    private String nombre;

    private String descripcion;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;

    public NivelMateria() {
        this.activo = true; // Por defecto true
    }

    public NivelMateria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = true; // Por defecto true
    }

    public NivelMateria(String nombre, String descripcion, Boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
