package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AsistenciaRequestDto {

    @NotNull(message = "El id del alumno es obligatorio")
    @Min(value = 1, message = "El id del alumno debe ser positivo")
    private Long alumnoId;

    @NotNull(message = "El id del registro de clase es obligatorio")
    @Min(value = 1, message = "El id del registro de clase debe ser positivo")
    private Long registroClaseId;

    @NotNull(message = "El campo presente es obligatorio")
    private Boolean presente;

    @Size(max = 255, message = "Las observaciones no pueden superar 255 caracteres")
    private String observaciones;

    @NotNull(message = "El campo tardanza es obligatorio")
    private Boolean tardanza;


    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getRegistroClaseId() {
        return registroClaseId;
    }

    public void setRegistroClaseId(Long registroClaseId) {
        this.registroClaseId = registroClaseId;
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

    public Boolean getTardanza() {
        return tardanza;
    }

    public void setTardanza(Boolean tardanza) {
        this.tardanza = tardanza;
    }
}
