package com.imb2025.calificaciones.dto.response;

public class SedeResponseDto {

    private Long id;
    private String nombre;
    private String direccion;
    private String localidad;
    private Long version;
    private Boolean activa;

    public SedeResponseDto() {}

    public SedeResponseDto(Long id, String nombre, String direccion, String localidad, Long version, Boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.version = version;
        this.activa = activa;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public Long getVersion() {
        return version;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}
