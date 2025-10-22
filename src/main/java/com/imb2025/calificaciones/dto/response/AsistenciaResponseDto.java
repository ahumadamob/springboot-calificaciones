package com.imb2025.calificaciones.dto.response;

public class AsistenciaResponseDto {
    private Long id;
    private String alumnoNombre;
    private String registroClaseTema;
    private Boolean presente;
    private String observaciones;
    private Long version;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlumnoNombre() {
        return alumnoNombre;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    public String getRegistroClaseTema() {
        return registroClaseTema;
    }

    public void setRegistroClaseTema(String registroClaseTema) {
        this.registroClaseTema = registroClaseTema;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
