package com.imb2025.calificaciones.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;

public class TurnoRequestDto {

	@NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
	
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean activo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
    
    
}
