package com.imb2025.calificaciones.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TurnoRequestDto {

	@NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
	
	@NotNull
    private LocalTime horaInicio;
	
	@NotNull
    private LocalTime horaFin;

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
}
