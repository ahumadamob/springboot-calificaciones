package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "requisito_materia")
public class RequisitoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "materia_correlativa_id", nullable = false)
    private Materia materiaCorrelativa;

    public RequisitoMateria() {
    }

    public RequisitoMateria(Long id, Materia materia, Materia materiaCorrelativa) {
        this.id = id;
        this.materia = materia;
        this.materiaCorrelativa = materiaCorrelativa;
    }

    public RequisitoMateria(Materia materia, Materia materiaCorrelativa) {
        this.materia = materia;
        this.materiaCorrelativa = materiaCorrelativa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateriaCorrelativa() {
        return materiaCorrelativa;
    }

    public void setMateriaCorrelativa(Materia materiaCorrelativa) {
        this.materiaCorrelativa = materiaCorrelativa;
    }
}
