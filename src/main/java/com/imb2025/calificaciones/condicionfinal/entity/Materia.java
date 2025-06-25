package com.imb2025.calificaciones.condicionfinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Materia {

    @Id
    private Long id;

    private String nombre;

    // Getters y setters
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
}
