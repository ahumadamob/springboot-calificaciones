package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Comision extends BaseEntity {

	private String nombre;
	
	private Boolean destacado = false;
	
        @ManyToOne
        private Turno turno;

        @ManyToOne
        private Sede sede;

        public Comision() {
        }

        public Comision(Long id, String nombre, Turno turno, Sede sede, Boolean destacado) {
                this.setId(id); // id viene de BaseEntity
                this.nombre = nombre;
                this.turno = turno;
                this.sede = sede;
                this.destacado = destacado;
        }

        public Comision(String nombre, Turno turno, Sede sede, Boolean destacado) {
                this.nombre = nombre;
                this.turno = turno;
                this.sede = sede;
                this.destacado = destacado;
        }
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

        public Turno getTurno() {
                return turno;
        }

        public void setTurno(Turno turno) {
                this.turno = turno;
        }

        public Sede getSede() {
                return sede;
        }

        public void setSede(Sede sede) {
                this.sede = sede;
        }

		public Boolean getDestacado() {
			return destacado;
		}

		public void setDestacado(Boolean destacado) {
			this.destacado = destacado;
		}

		
}

