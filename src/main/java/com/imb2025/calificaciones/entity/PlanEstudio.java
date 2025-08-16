package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PlanEstudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    private String nombre;

    private int anioVigencia;

    public PlanEstudio() {
    }

    public PlanEstudio(Carrera carrera, String nombre, int anioVigencia) {
        this.carrera = carrera;
        this.nombre = nombre;
        this.anioVigencia = anioVigencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioVigencia() {
        return anioVigencia;
    }

    public void setAnioVigencia(int anioVigencia) {
        this.anioVigencia = anioVigencia;
    }
}
