package com.imb2025.calificaciones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ObraSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(name = "telefono_contacto", length = 30)
    private String telefonoContacto;

    public ObraSocial() {
    }

    public ObraSocial(Long id, String nombre, String descripcion, String telefonoContacto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefonoContacto = telefonoContacto;
    }

    public ObraSocial(String nombre, String descripcion, String telefonoContacto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefonoContacto = telefonoContacto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}
