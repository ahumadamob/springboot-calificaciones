package com.imb2025.calificaciones.entity;

import java.time.LocalDate;

import com.imb2025.calificaciones.enums.EstadoInscripcionMateria;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class InscripcionMateria extends BaseEntity {

    
    @ManyToOne
    private Alumno alumno;
    @ManyToOne
    private Materia materia;
    @ManyToOne
    private PeriodoLectivo periodoLectivo;
    private boolean inscripto;
    private String identificadorLegible;
    private LocalDate fechaVigencia;
    @Enumerated(EnumType.STRING)
    private EstadoInscripcionMateria estado = EstadoInscripcionMateria.ACTIVO;
    
    public InscripcionMateria() {
    }

    public InscripcionMateria(Alumno alumno, Materia materia, PeriodoLectivo periodoLectivo, boolean inscripto, String identificadorLegible) {
        this.alumno = alumno;
        this.materia = materia;
        this.periodoLectivo = periodoLectivo;
        this.inscripto = inscripto;
        this.identificadorLegible = identificadorLegible;
    }

    public Alumno getAlumno() {
        return alumno;
    }
    public boolean isInscripto() {
        return inscripto;
    }

    public void setInscripto(boolean inscripto) {
        this.inscripto = inscripto;
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

    public String getIdentificadorLegible() {
        return identificadorLegible;
    }

    public void setIdentificadorLegible(String identificadorLegible) {
        this.identificadorLegible = identificadorLegible;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public EstadoInscripcionMateria getEstado() {
        return estado;
    }

    public void setEstado(EstadoInscripcionMateria estado) {
        this.estado = estado;
    }
    
}
