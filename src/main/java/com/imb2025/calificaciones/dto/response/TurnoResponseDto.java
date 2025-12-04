package com.imb2025.calificaciones.dto.response;

import java.time.LocalTime;

public class TurnoResponseDto {
	
	private Long id;
	private String nombre;
	private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long version;
    private int prioridad;
    
    
	public TurnoResponseDto() {
		
	}

	
	


	public TurnoResponseDto(Long id, String nombre, LocalTime horaInicio, LocalTime horaFin, Long version,
			int prioridad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.version = version;
		this.prioridad = prioridad;
	}





	public int getPrioridad() {
		return prioridad;
	}





	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
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


	public Long getVersion() {
		return version;
	}


	public void setVersion(Long version) {
		this.version = version;
	}


    
    
	

}
