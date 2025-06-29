package com.imb2025.calificaciones.dto;


	public class CursadaRequestDTO {
	    private Long alumnoId;
	    private Long materiaId;
	    private String anioLectivoId;
	    private Long condicionFinalId;



	    public Long getAlumnoId() {
	        return alumnoId;
	    }
	    public void setAlumnoId(Long alumnoId) {
	        this.alumnoId = alumnoId;
	    }
	    public Long getMateriaId() {
	        return materiaId;
	    }
	    public void setMateriaId(Long materiaId) {
	        this.materiaId = materiaId;
	    }
	    public String getAnioLectivoId() {
	        return anioLectivoId;
	    }
	    public void setAnioLectivoId(String anioLectivoId) {
	        this.anioLectivoId = anioLectivoId;
	    }
	    public Long getCondicionFinalId() {
	        return condicionFinalId;
	    }
	    public void setCondicionFinalId(Long condicionFinalId) {
	        this.condicionFinalId = condicionFinalId;
	    }

	}

