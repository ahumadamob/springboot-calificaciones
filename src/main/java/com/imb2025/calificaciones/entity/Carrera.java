package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String tituloOtorgado;

    public Carrera() {
    }

    public Carrera(Long id, String nombre, String tituloOtorgado) {
        this.id = id;
        this.nombre = nombre;
        this.tituloOtorgado = tituloOtorgado;
    }

    public Carrera(String nombre, String tituloOtorgado) {
        this.nombre = nombre;
        this.tituloOtorgado = tituloOtorgado;
    }

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

    public String getTituloOtorgado() {
        return tituloOtorgado;
    }

    public void setTituloOtorgado(String tituloOtorgado) {
        this.tituloOtorgado = tituloOtorgado;
    }
}
