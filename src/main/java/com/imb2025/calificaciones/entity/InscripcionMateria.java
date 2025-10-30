package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class InscripcionMateria extends BaseEntity {

    
    @ManyToOne
    private Alumno alumno;
    @ManyToOne
    private Materia materia;
    @ManyToOne
    private PeriodoLectivo periodoLectivo;

    public InscripcionMateria() {
    }

    public InscripcionMateria(Alumno alumno, Materia materia, PeriodoLectivo periodoLectivo) {
        this.alumno = alumno;
        this.materia = materia;
        this.periodoLectivo = periodoLectivo;
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
