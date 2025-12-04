package com.imb2025.calificaciones.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;

@Entity
public class Turno extends BaseEntity {
	
        private String nombre;

        private int prioridad;
        private LocalTime horaInicio;

        private LocalTime horaFin;

        public Turno() {
        }

       
	

	public Turno(String nombre, int prioridad, LocalTime horaInicio, LocalTime horaFin) {
			super();
			this.nombre = nombre;
			this.prioridad = prioridad;
			this.horaInicio = horaInicio;
			this.horaFin = horaFin;
		}




	public int getPrioridad() {
		return prioridad;
	}




	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
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

}
