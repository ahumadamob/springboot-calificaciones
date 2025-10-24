package com.imb2025.calificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TipoEvaluacionRequestDto {

	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres")
	@Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$",
	        message = "El nombre solo puede contener letras y espacios")
    private String nombre;
    
    @Size(max = 200, 
    		message = "La descripción no debe superar los 200 caracteres")    
    private String descripcion;
    
    @Pattern (regexp = "^(?i)(ACTIVO|INACTIVO)$",
    		message = "El estado puede ser ACTIVO o INACTIVO")
    private String estado;
        

    //getters and setters
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
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }    
}
