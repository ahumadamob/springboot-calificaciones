package com.imb2025.calificaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AsignacionDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long docenteId;
    private Long materiaId;
    private Long comisionId;
    private Long periodoLectivoId;

    public AsignacionDocente() {
    }

    public AsignacionDocente(Long id, Long docenteId, Long materiaId, Long comisionId, Long periodoLectivoId) {
        this.id = id;
        this.docenteId = docenteId;
        this.materiaId = materiaId;
        this.comisionId = comisionId;
        this.periodoLectivoId = periodoLectivoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Long getComisionId() {
        return comisionId;
    }

    public void setComisionId(Long comisionId) {
        this.comisionId = comisionId;
    }

    public Long getPeriodoLectivoId() {
        return periodoLectivoId;
    }

    public void setPeriodoLectivoId(Long periodoLectivoId) {
        this.periodoLectivoId = periodoLectivoId;
    }

}
