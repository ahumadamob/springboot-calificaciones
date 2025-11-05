package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;

@Entity
public class Carrera extends BaseEntity {

    private String nombre;

    private String tituloOtorgado;

    public Carrera() {
    }

    public Carrera(Long id, String nombre, String tituloOtorgado) {
        this.setId(id);
        this.nombre = nombre;
        this.tituloOtorgado = tituloOtorgado;
    }

    public Carrera(String nombre, String tituloOtorgado) {
        this.nombre = nombre;
        this.tituloOtorgado = tituloOtorgado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTituloOtorgado() {
        return tituloOtorgado;
    }

    public void setTituloOtorgado(String tituloOtorgado) {
        this.tituloOtorgado = tituloOtorgado;
    }
}