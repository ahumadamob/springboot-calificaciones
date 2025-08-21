package com.imb2025.calificaciones.dto;

import jakarta.validation.constraints.NotNull;

public class AsistenciaRequestDto {

    private Long alumnoId;
    private Long registroClaseId;

    @NotNull(message = "El campo presente es obligatorio.")
    private Boolean presente;

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
}
