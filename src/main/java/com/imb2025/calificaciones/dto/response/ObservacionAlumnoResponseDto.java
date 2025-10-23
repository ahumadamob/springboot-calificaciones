package com.imb2025.calificaciones.dto.response;

import java.util.Date;

import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Docente;



public class ObservacionAlumnoResponseDto {
	
	private Long id;
	
	private Boolean revisada;
	
    private Alumno alumno;
	
    private Docente docente;
	
    private String texto;
	
    private Date fecha;
    
    private Long version;

	public ObservacionAlumnoResponseDto() {
		super();
	}

	public ObservacionAlumnoResponseDto(Long id, Boolean revisada, Alumno alumno, Docente docente, String texto, Date fecha,
			Long version) {
		super();
		this.id = id;
		this.revisada = revisada;
		this.alumno = alumno;
		this.docente = docente;
		this.texto = texto;
		this.fecha = fecha;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getRevisada() {
		return revisada;
	}

	public void setRevisada(Boolean revisada) {
		this.revisada = revisada;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	
    

}
