package com.imb2025.calificaciones.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "requisito_materia")
public class RequisitoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long materiaId;

    private Long materiaCorrelativaId;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMateriaId() { return materiaId; }
    public void setMateriaId(Long materiaId) { this.materiaId = materiaId; }

    public Long getMateriaCorrelativaId() { return materiaCorrelativaId; }
    public void setMateriaCorrelativaId(Long materiaCorrelativaId) { this.materiaCorrelativaId = materiaCorrelativaId; }
}

