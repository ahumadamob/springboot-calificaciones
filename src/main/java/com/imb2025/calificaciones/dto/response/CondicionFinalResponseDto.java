package com.imb2025.calificaciones.dto.response;

import java.time.LocalDateTime;

public class CondicionFinalResponseDto {

    private Long id;
    private String nombre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long version;
    private String descripcionCorta;

    public CondicionFinalResponseDto() {}

    public CondicionFinalResponseDto(Long id, String nombre, LocalDateTime createdAt, LocalDateTime updatedAt, Long version, String descripcionCorta) {
        this.id = id;
        this.nombre = nombre;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.version = version;
        this.descripcionCorta = descripcionCorta;
        
    }

    public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
