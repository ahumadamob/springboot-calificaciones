package com.imb2025.calificaciones.dto.request;

import java.time.LocalDate;

import com.imb2025.calificaciones.enums.EstadoInscripcionMateria;

import jakarta.validation.constraints.Positive;

public class InscripcionMateriaRequestDto {
    @Positive(message = "Debe ingresar un id positivo de alumno")
    private Long alumnoId;
    @Positive(message = "Debe ingresar un id positivo de materia")
    private Long materiaId;
    @Positive(message = "Debe ingresar un id positivo de periodo")
    private Long periodoLectivoId;

    private Boolean inscripto;
    
    private String identificadorLegible;
    
    private LocalDate fechaVigencia;

    private EstadoInscripcionMateria estado;
    
    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Long getPeriodoLectivoId() {
        return periodoLectivoId;
    }

    public void setPeriodoLectivoId(Long periodoLectivoId) {
        this.periodoLectivoId = periodoLectivoId;
    }

    public Boolean getInscripto() {
        return inscripto;
    }

    public void setInscripto(Boolean inscripto) {
        this.inscripto = inscripto;
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
