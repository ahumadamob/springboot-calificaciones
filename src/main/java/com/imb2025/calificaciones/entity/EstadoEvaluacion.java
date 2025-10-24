package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class EstadoEvaluacion extends BaseEntity {

    private String nombre;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private ResultadoEvaluacion resultado; 

    public enum ResultadoEvaluacion {
        PROMOCIONADO,
        APROBADO,
        DESAPROBADO
    }

    public EstadoEvaluacion() {
    }

    public EstadoEvaluacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public ResultadoEvaluacion getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEvaluacion resultado) {
        this.resultado = resultado;
    }
}
