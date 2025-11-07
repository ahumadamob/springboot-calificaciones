package com.imb2025.calificaciones.dto.response;


public class NivelMateriaResponseDto {
	
	private String identificadorLegible;

	public String getIdentificadorLegible() { return identificadorLegible; }
	public void setIdentificadorLegible(String identificadorLegible) { this.identificadorLegible = identificadorLegible; }

	// y en el constructor con parámetros:
	public NivelMateriaResponseDto(Long id, String nombre, String descripcion, Boolean activo, Long version, String identificadorLegible) {
	    this.id = id;
	    this.nombre = nombre;
	    this.descripcion = descripcion;
	    this.activo = activo;
	    this.version = version;
	    this.identificadorLegible = identificadorLegible;
	}

    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean activo;
    private Long version;

    public NivelMateriaResponseDto() {
    }

    public NivelMateriaResponseDto(Long id, String nombre, String descripcion, Boolean activo, Long version) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.version = version;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
