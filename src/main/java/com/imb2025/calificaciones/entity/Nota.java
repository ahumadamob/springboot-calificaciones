package com.imb2025.calificaciones.entity;

import jakarta.persistence.*;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Evaluacion evaluacion;

    @ManyToOne
    private Alumno alumno;

    private Double valor;

    private String observaciones;

    public Nota() {
    }

    public Nota(Long id, Evaluacion evaluacion, Alumno alumno, Double valor, String observaciones) {
        this.id = id;
        this.evaluacion = evaluacion;
        this.alumno = alumno;
        this.valor = valor;
        this.observaciones = observaciones;
    }

    public Nota(Evaluacion evaluacion, Alumno alumno, Double valor, String observaciones) {
        this.evaluacion = evaluacion;
        this.alumno = alumno;
        this.valor = valor;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
