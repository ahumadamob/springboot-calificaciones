package com.imb2025.calificaciones.dto.response;

import java.time.LocalDate;
import java.util.Date;

import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.ObservacionAlumno.Categoria;



public class ObservacionAlumnoResponseDto {
	
	private Long id;
	
    private Alumno alumno;
	
    private Docente docente;
	
    private String texto;
	
    private Date fecha;
    
    private Long version;
    
    private LocalDate fechaVigencia;
    
    private Categoria categoria;
    

	public ObservacionAlumnoResponseDto() {
		super();
	}


	public ObservacionAlumnoResponseDto(Long id, Alumno alumno, Docente docente, String texto, Date fecha, Long version,
			LocalDate fechaVigencia, Categoria categoria) {
		super();
		this.id = id;
		this.alumno = alumno;
		this.docente = docente;
		this.texto = texto;
		this.fecha = fecha;
		this.version = version;
		this.fechaVigencia = fechaVigencia;
		this.categoria = categoria;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDate getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(LocalDate fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
