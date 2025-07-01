package com.imb2025.calificaciones.dto;

public class NivelMateriaResponseDTO {

	
	 private Long id;
	    private String nombre;
	    private Long nivelId;
	    private String nivelNombre;
	    private Long materiaId;
	    private String materiaNombre;

	    public NivelMateriaResponseDTO() {
	    }

	    public NivelMateriaResponseDTO(Long id, String nombre, Long nivelId, String nivelNombre, Long materiaId, String materiaNombre) {
	        this.id = id;
	        this.nombre = nombre;
	        this.nivelId = nivelId;
	        this.nivelNombre = nivelNombre;
	        this.materiaId = materiaId;
	        this.materiaNombre = materiaNombre;
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

	    public Long getNivelId() {
	        return nivelId;
	    }

	    public void setNivelId(Long nivelId) {
	        this.nivelId = nivelId;
	    }

	    public String getNivelNombre() {
	        return nivelNombre;
	    }

	    public void setNivelNombre(String nivelNombre) {
	        this.nivelNombre = nivelNombre;
	    }

	    public Long getMateriaId() {
	        return materiaId;
	    }

	    public void setMateriaId(Long materiaId) {
	        this.materiaId = materiaId;
	    }

	    public String getMateriaNombre() {
	        return materiaNombre;
	    }

	    public void setMateriaNombre(String materiaNombre) {
	        this.materiaNombre = materiaNombre;
	    }
	}	
	
	
	

