package com.imb2025.calificaciones.dto.response;

public class CarreraResponseDto {
	
	 private Long id;
	    private String nombre;
	    private String tituloOtorgado;
	    private Boolean activa;

	    public CarreraResponseDto() {
	    }

	    public CarreraResponseDto(Long id, String nombre, String tituloOtorgado, Boolean activa) {
	        this.id = id;
	        this.nombre = nombre;
	        this.tituloOtorgado = tituloOtorgado;
	        this.activa = activa;
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

	    public String getTituloOtorgado() {
	        return tituloOtorgado;
	    }

	    public void setTituloOtorgado(String tituloOtorgado) {
	        this.tituloOtorgado = tituloOtorgado;
	    }

	    public Boolean getActiva() {
	        return activa;
	    }

	    public void setActiva(Boolean activa) {
	        this.activa = activa;
	    }

}
