package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import com.imb2025.calificaciones.entity.BaseEntity;

@Entity
public class Comision extends BaseEntity {

	private String nombre;
	
        @ManyToOne
        private Turno turno;

        @ManyToOne
        private Sede sede;

        public Comision() {
        }

        public Comision(Long id, String nombre, Turno turno, Sede sede) {
                this.setId(id); // id viene de BaseEntity
                this.nombre = nombre;
                this.turno = turno;
                this.sede = sede;
        }

        public Comision(String nombre, Turno turno, Sede sede) {
                this.nombre = nombre;
                this.turno = turno;
                this.sede = sede;
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
}
