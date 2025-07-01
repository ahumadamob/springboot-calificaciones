package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.imb2025.calificaciones.entity.Nivel;
import com.imb2025.calificaciones.entity.Materia;

@Entity
public class NivelMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "nivel_id")
    private Nivel nivel;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;
    
    public Nivel getNivel() {
        return nivel;
    }
    public Materia getMateria() {
        return materia;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;  // Aquí asignamos el valor
    }
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;      // Aquí asignamos el valor
    }
}