package com.imb2025.calificaciones.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class ObservacionAlumnoRequestDto {

	@NotNull
    private Long alumnoId;
	@NotNull
    private Long docenteId;
	@NotBlank
    private String texto;
	@PastOrPresent
    private Date fecha;
	@NotNull
	private Boolean revisada;

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }    

	public Boolean getRevisada() {
		return revisada;
	}

	public void setRevisada(Boolean revisada) {
		this.revisada = revisada;
	}

	public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
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
}
