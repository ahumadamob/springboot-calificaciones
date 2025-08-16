package com.imb2025.calificaciones.dto;

public class PlanEstudioRequestDto {

    private Long carreraId;
    private String nombre;
    private int anioVigencia;

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioVigencia() {
        return anioVigencia;
    }

    public void setAnioVigencia(int anioVigencia) {
        this.anioVigencia = anioVigencia;
    }
}
