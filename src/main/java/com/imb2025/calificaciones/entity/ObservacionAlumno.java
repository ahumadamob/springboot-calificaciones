package com.imb2025.calificaciones.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ObservacionAlumno extends BaseEntity{
	
    private String texto;
    private Date fecha;
    
    @ManyToOne
    private Docente docente;

    @ManyToOne
    private Alumno alumno;

    public ObservacionAlumno() {
    }


    public ObservacionAlumno(String texto, Date fecha, Docente docente, Alumno alumno) {
        this.texto = texto;
        this.fecha = fecha;
        this.docente = docente;
        this.alumno = alumno;
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
