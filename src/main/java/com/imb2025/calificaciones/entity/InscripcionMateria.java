package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class InscripcionMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Alumno alumno;
    @ManyToOne
    private Materia materia;
    @ManyToOne
    private PeriodoLectivo periodoLectivo;

    public InscripcionMateria() {
    }

    public InscripcionMateria(Long id, Alumno alumno, Materia materia, PeriodoLectivo periodoLectivo) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.periodoLectivo = periodoLectivo;
    }

    public InscripcionMateria(Alumno alumno, Materia materia, PeriodoLectivo periodoLectivo) {
        this.alumno = alumno;
        this.materia = materia;
        this.periodoLectivo = periodoLectivo;
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
    public PeriodoLectivo getPeriodoLectivo() {
        return periodoLectivo;
    }
    public void setPeriodoLectivo(PeriodoLectivo periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    
}
