package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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

    public Asistencia() {
    }

    public Asistencia(Long id, Alumno alumno, RegistroClase registroClase, Boolean presente) {
        this.id = id;
        this.alumno = alumno;
        this.registroClase = registroClase;
        this.presente = presente;
    }

    public Asistencia(Alumno alumno, RegistroClase registroClase, Boolean presente) {
        this.alumno = alumno;
        this.registroClase = registroClase;
        this.presente = presente;
    }

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
