package com.imb2025.calificaciones.entity;

import jakarta.persistence.*;

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
    

    // Getters y Setters
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
