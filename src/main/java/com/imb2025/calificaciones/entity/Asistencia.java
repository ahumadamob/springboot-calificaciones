package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Asistencia extends BaseEntity {

    @ManyToOne
    private Alumno alumno;

    @ManyToOne
    private RegistroClase registroClase;

    private Boolean presente;

    private String observaciones;

    public Asistencia() {
    }

    public Asistencia(Alumno alumno, RegistroClase registroClase, Boolean presente, String observaciones) {
        this.alumno = alumno;
        this.registroClase = registroClase;
        this.presente = presente;
        this.observaciones = observaciones;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
