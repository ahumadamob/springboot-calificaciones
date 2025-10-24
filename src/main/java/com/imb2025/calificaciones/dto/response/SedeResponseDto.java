package com.imb2025.calificaciones.dto.response;

public class SedeResponseDto {

    private Long id;
    private String nombre;
    private String direccion;
    private Long localidadId;
    private Long version;

    public SedeResponseDto() {}

    public SedeResponseDto(Long id, String nombre, String direccion, Long localidadId, Long version) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidadId = localidadId;
        this.version = version;
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

    public Long getLocalidadId() {
        return localidadId;
    }

    public Long getVersion() {
        return version;
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

    public void setLocalidadId(Long localidadId) {
        this.localidadId = localidadId;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
