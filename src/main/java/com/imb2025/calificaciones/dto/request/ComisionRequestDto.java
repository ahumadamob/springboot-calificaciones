package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ComisionRequestDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El id del turno es obligatorio")
    @Positive(message = "El id del turno debe ser un número positivo")
    private Long turnoId;

    @NotNull(message = "El id de la sede es obligatorio")
    @Positive(message = "El id de la sede debe ser un número positivo")
    private Long sedeId;

    private Boolean destacado;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Long turnoId) {
        this.turnoId = turnoId;
    }

    public Long getSedeId() {
        return sedeId;
    }

    public void setSedeId(Long sedeId) {
        this.sedeId = sedeId;
    }

	public Boolean getDestacado() {
		return destacado;
	}

	public void setDestacado(Boolean destacado) {
		this.destacado = destacado;
	}

	
    
}

//@NotBlank: Asegura que el String no sea null, ni vacío, ni solo espacios en blanco.
// Es la validación estándar para campos de texto obligatorios.

//@Size: Limita la longitud del String. Ayuda a evitar que el usuario 
// ingrese datos que sobrepasen la capacidad de la columna en la BD.

//@NotNull: Asegura que el valor del Long (un tipo de objeto) no sea null.

