package com.imb2025.calificaciones.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RegistroClase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private String tema;

    @ManyToOne
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "comision_id", nullable = false)
    private Comision comision;
    
    public RegistroClase() {
    }

    public RegistroClase(Long id, LocalDate fecha, String tema, Docente docente, Comision comision) {
        this.id = id;
        this.fecha = fecha;
        this.tema = tema;
        this.docente = docente;
        this.comision = comision;
    }

    public RegistroClase(LocalDate fecha, String tema, Docente docente, Comision comision) {
        this.fecha = fecha;
        this.tema = tema;
        this.docente = docente;
        this.comision = comision;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Comision getComision() {
        return comision;
    }

    public void setComision(Comision comision) {
        this.comision = comision;
    }
}
