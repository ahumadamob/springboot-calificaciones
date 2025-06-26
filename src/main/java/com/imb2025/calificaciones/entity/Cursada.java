package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Entity
public class Cursada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Alumno: muchos cursadas pueden tener un mismo alumno
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    // Relación con Materia: muchos cursadas pueden tener una misma materia
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    private String anioLectivo;

    // Relación con CondicionFinal: muchos cursadas pueden tener una misma condición
    @ManyToOne
    @JoinColumn(name = "condicion_final_id")
    private CondicionFinal condicionFinal;

  
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

    public String getAnioLectivo() {
        return anioLectivo;
    }

    public void setAnioLectivo(String anioLectivo) {
        this.anioLectivo = anioLectivo;
    }

    public CondicionFinal getCondicionFinal() {
        return condicionFinal;
    }

    public void setCondicionFinal(CondicionFinal condicionFinal) {
        this.condicionFinal = condicionFinal;
    }
}
