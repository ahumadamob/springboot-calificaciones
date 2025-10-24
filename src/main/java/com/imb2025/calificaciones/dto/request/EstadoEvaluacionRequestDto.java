package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;

public class EstadoEvaluacionRequestDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotNull(message = "El resultado es obligatorio")
    private EstadoEvaluacion.ResultadoEvaluacion resultado; 

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

    public EstadoEvaluacion.ResultadoEvaluacion getResultado() {
        return resultado;
    }

    public void setResultado(EstadoEvaluacion.ResultadoEvaluacion resultado) {
        this.resultado = resultado;
    }
}
