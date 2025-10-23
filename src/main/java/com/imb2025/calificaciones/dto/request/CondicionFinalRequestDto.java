package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CondicionFinalRequestDto {

    // Se añade @NotBlank para asegurar que el nombre no sea vacío o solo espacios.
    @NotBlank(message = "El nombre de la condición es obligatorio y no puede estar vacío.")
    private String nombre;
    
    // Se añade @NotNull. Si este campo es omitido o enviado como null,
    // se activará el GlobalExceptionHandler para devolver el error 400 con la lista de errores.
    @NotNull(message = "El atributo 'esVigente' es obligatorio.")
    private Boolean esVigente; // Nuevo atributo

    public CondicionFinalRequestDto() {}

    public CondicionFinalRequestDto(String nombre, Boolean esVigente) { // Actualizar constructor
        this.nombre = nombre;
        this.esVigente = esVigente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Nuevo Getter y Setter
    public Boolean getEsVigente() {
        return esVigente;
    }

    public void setEsVigente(Boolean esVigente) {
        this.esVigente = esVigente;
    }
}