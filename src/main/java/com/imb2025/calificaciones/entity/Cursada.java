package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cursada extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "anio_lectivo_id")
    private AnioLectivo anioLectivo;

    @ManyToOne
    @JoinColumn(name = "condicion_final_id")
    private CondicionFinal condicionFinal;

    private boolean regular;
    
    public Cursada() {
    }

    public Cursada(Alumno alumno, Materia materia, AnioLectivo anioLectivo, CondicionFinal condicionFinal) {
        
        this.alumno = alumno;
        this.materia = materia;
        this.anioLectivo = anioLectivo;
        this.condicionFinal = condicionFinal;
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

    public AnioLectivo getAnioLectivo() {
        return anioLectivo;
    }

    public void setAnioLectivo(AnioLectivo anioLectivo) {
        this.anioLectivo = anioLectivo;
    }

    public CondicionFinal getCondicionFinal() {
        return condicionFinal;
    }

    public void setCondicionFinal(CondicionFinal condicionFinal) {
        this.condicionFinal = condicionFinal;
    }
    public boolean isRegular() {
        return regular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }
}
