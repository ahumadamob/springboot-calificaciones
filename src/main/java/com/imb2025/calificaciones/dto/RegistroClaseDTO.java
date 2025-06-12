package com.imb2025.calificaciones.dto;


import jakarta.validation.constraints.NotNull;

public class RegistroClaseDTO {
    @NotNull(message = "El tema es obligatorio")
    private String tema;
    @NotNull(message = "El ID  del docente es obligatorio")
    private Long docenteId;
    @NotNull(message = "El ID de la comision es obligatorio")
    private Long comisionId;


    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public Long getDocenteId() {
        return docenteId;
    }
    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }
    public Long getComisionId() {
        return comisionId;
    }
    public void setComisionId(Long comisionId) {
        this.comisionId = comisionId;
    }






}
