package com.imb2025.calificaciones.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ObservacionAlumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
    private String texto;
    private Date fecha;
    
    @ManyToOne
    private Docente docente;

    @ManyToOne
    private Alumno alumno;

    public ObservacionAlumno() {
    }

    public ObservacionAlumno(Long id, String texto, Date fecha, Docente docente, Alumno alumno) {
        this.id = id;
        this.texto = texto;
        this.fecha = fecha;
        this.docente = docente;
        this.alumno = alumno;
    }

    public ObservacionAlumno(String texto, Date fecha, Docente docente, Alumno alumno) {
        this.texto = texto;
        this.fecha = fecha;
        this.docente = docente;
        this.alumno = alumno;
    }
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	
}
