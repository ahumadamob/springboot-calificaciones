package com.imb2025.calificaciones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class NivelMateria extends BaseEntity {

    private String nombre;

    private String descripcion;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;

    // nuevo campo identificador legible (no @Id, no unique en DB)
    @Column(nullable = false)
    private String identificadorLegible;

    public NivelMateria() {
        this.activo = true; // Por defecto true
    }

    // constructor con identificador
    public NivelMateria(String nombre, String descripcion, Boolean activo, String identificadorLegible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.identificadorLegible = identificadorLegible;
    }

    // constructor sin identificador (opcional)
    public NivelMateria(String nombre, String descripcion, Boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    // getters / setters
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

    public String getIdentificadorLegible() {
        return identificadorLegible;
    }

    public void setIdentificadorLegible(String identificadorLegible) {
        this.identificadorLegible = identificadorLegible;
    }
}