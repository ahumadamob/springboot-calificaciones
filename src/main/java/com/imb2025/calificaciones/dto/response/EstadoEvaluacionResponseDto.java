package com.imb2025.calificaciones.dto.response;

import com.imb2025.calificaciones.entity.EstadoEvaluacion;

public class EstadoEvaluacionResponseDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long version;
    private EstadoEvaluacion.ResultadoEvaluacion resultado; 

    public EstadoEvaluacionResponseDto() {
    }

    public EstadoEvaluacionResponseDto(Long id, String nombre, String descripcion, Long version) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.version = version;
    }

    // Getters y Setters

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public EstadoEvaluacion.ResultadoEvaluacion getResultado() {
        return resultado;
    }

    public void setResultado(EstadoEvaluacion.ResultadoEvaluacion resultado) {
        this.resultado = resultado;
    }
}
