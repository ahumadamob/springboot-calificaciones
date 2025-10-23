package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;

@Entity
public class CondicionFinal extends BaseEntity {

    private String nombre;
    private Boolean esVigente; // Nuevo atributo booleano

    public CondicionFinal() {}

    public CondicionFinal(String nombre, Boolean esVigente) {
        this.nombre = nombre;
        this.esVigente = esVigente; // Actualizar constructor
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Nuevo Getter y Setter
    public Boolean getEsVigente() {
        return esVigente;
    }

    public void setEsVigente(Boolean esVigente) {
        this.esVigente = esVigente;
    }
}