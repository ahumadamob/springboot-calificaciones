package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

@Entity
public class Comision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
        @ManyToOne
        private Turno turno;

        @ManyToOne
        private Sede sede;

        // Versión para optimistic locking / respuesta DTO
        @Version
        private Long version;

        public Comision() {
        }

        public Comision(Long id, String nombre, Turno turno, Sede sede) {
                this.id = id;
                this.nombre = nombre;
                this.turno = turno;
                this.sede = sede;
        }

        public Comision(String nombre, Turno turno, Sede sede) {
                this.nombre = nombre;
                this.turno = turno;
                this.sede = sede;
        }
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

        public Long getVersion() {
                return version;
        }

        public void setVersion(Long version) {
                this.version = version;
        }
	
}
