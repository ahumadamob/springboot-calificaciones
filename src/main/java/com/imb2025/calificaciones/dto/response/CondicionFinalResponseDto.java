package com.imb2025.calificaciones.dto.response;

public class CondicionFinalResponseDto {

    private Long id;
    private String nombre;
    private Long version;

    public CondicionFinalResponseDto() {
    }

    public CondicionFinalResponseDto(Long id, String nombre, Long version) {
        this.id = id;
        this.nombre = nombre;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
