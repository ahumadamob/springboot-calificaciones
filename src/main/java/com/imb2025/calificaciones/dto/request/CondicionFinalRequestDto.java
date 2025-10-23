package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CondicionFinalRequestDto {

    @NotBlank(message = "El nombre de la condición es obligatorio y no puede estar vacío.")
    private String nombre;
    
    @NotNull(message = "El atributo 'esVigente' es obligatorio.")
    private Boolean esVigente; 

    public CondicionFinalRequestDto() {}

    public CondicionFinalRequestDto(String nombre, Boolean esVigente) { 
        this.nombre = nombre;
        this.esVigente = esVigente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   
    public Boolean getEsVigente() {
        return esVigente;
    }

    public void setEsVigente(Boolean esVigente) {
        this.esVigente = esVigente;
    }
}