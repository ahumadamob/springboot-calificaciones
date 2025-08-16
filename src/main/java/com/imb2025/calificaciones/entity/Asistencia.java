package com.imb2025.calificaciones.entity;

import jakarta.persistence.*;

@Entity
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Alumno alumno;

    @ManyToOne
    private RegistroClase registroClase;

    private Boolean presente;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public RegistroClase getRegistroClase() {
        return registroClase;
    }

    public void setRegistroClase(RegistroClase registroClase) {
        this.registroClase = registroClase;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }
}
