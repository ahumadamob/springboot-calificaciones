package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;

@Entity
public class CondicionFinal extends BaseEntity {

    private String nombre;
    private Boolean esVigente; 

    public CondicionFinal() {}

    public CondicionFinal(String nombre, Boolean esVigente) {
        this.nombre = nombre;
        this.esVigente = esVigente; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public Boolean getEsVigente() {
        return esVigente;
    }

    public void setEsVigente(Boolean esVigente) {
        this.esVigente = esVigente;
    }
}