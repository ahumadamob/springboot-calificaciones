package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Docente {
		 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String nombre  ;
        private String apellido ;
        private Long legajo ;
        private String email ;
        private String titulo ;


        public Docente() {
        }

        public Docente(Long id, String nombre, String apellido, Long legajo, String email, String titulo) {
                this.id = id;
                this.nombre = nombre;
                this.apellido = apellido;
                this.legajo = legajo;
                this.email = email;
                this.titulo = titulo;
        }

        public Docente(String nombre, String apellido, Long legajo, String email, String titulo) {
                this.nombre = nombre;
                this.apellido = apellido;
                this.legajo = legajo;
                this.email = email;
                this.titulo = titulo;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getLegajo() {
		return legajo;
	}
	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	
	
	
	
	
	
	
	
}




