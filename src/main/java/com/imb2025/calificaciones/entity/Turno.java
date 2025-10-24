package com.imb2025.calificaciones.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Turno extends BaseEntity {
	
	
        private String nombre;

        
        private LocalTime horaInicio;

        private LocalTime horaFin;
        
        private boolean activo;

        public Turno() {
        }

        public Turno(String nombre, LocalTime horaInicio, LocalTime horaFin, boolean activo) {
                
                this.nombre = nombre;
                this.horaInicio = horaInicio;
                this.horaFin = horaFin;
                this.activo = activo;
        }
	

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
