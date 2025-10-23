package com.imb2025.calificaciones.dto.response;

import java.time.LocalDateTime;

public class CondicionFinalResponseDto {

    private Long id;
    private String nombre;
    private Boolean esVigente; // Nuevo atributo
    
    // Eliminados: createdAt y updatedAt (según consigna del TP Parcial)
    private Long version;

    public CondicionFinalResponseDto() {}

    public CondicionFinalResponseDto(Long id, String nombre, Boolean esVigente, Long version) { // Constructor actualizado
        this.id = id;
        this.nombre = nombre;
        this.esVigente = esVigente;
        this.version = version;
    }

    // Getters y Setters
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
    
    public Boolean getEsVigente() { // Nuevo
        return esVigente;
    }

    public void setEsVigente(Boolean esVigente) { // Nuevo
        this.esVigente = esVigente;
    }

    // Eliminados: getCreatedAt() y getUpdatedAt()
    
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}