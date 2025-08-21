package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PromedioAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Alumno alumno;

    @ManyToOne
    private Materia materia;

    private Double promedio;

    public PromedioAlumno() {
    }

    public PromedioAlumno(Alumno alumno, Materia materia, Double promedio) {
        this.alumno = alumno;
        this.materia = materia;
        this.promedio = promedio;
    }

    public PromedioAlumno(Long id, Alumno alumno, Materia materia, Double promedio) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.promedio = promedio;
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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
}

