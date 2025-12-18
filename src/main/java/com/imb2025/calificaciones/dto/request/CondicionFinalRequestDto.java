package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CondicionFinalRequestDto {

    private String nombre;
    
    
    @NotNull(message = "La descripcion no debe ser nula.")
    
	@Size(min = 5, message = "La descripcion debe ser más larga que 5 caracteres.")
    
	private String descripcionCorta;

    public CondicionFinalRequestDto() {}

    public CondicionFinalRequestDto(String nombre, String descripcionCorta) {
        this.nombre = nombre;
        this.descripcionCorta = descripcionCorta;
    }
    

    public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
