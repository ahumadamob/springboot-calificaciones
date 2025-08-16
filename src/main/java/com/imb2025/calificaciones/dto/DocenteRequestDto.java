package com.imb2025.calificaciones.dto;

public class DocenteRequestDto {
	
	private String nombre  ;
	private String apellido ;
	private Long legajo ;
	private String email ;
	private String titulo ;
	
	public DocenteRequestDto() {
		
	}
	
	public DocenteRequestDto(String nombre, String apellido, Long legajo, String email, String titulo) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.email = email;
		this.titulo = titulo;
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
