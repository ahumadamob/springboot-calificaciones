package com.imb2025.calificaciones.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class RegistroClaseRequestDto {

    @NotNull(message = "La fecha es obligatoria")
    @PastOrPresent(message = "La fecha debe ser pasada o la actual")
    private LocalDate fecha;

    @NotBlank(message = "El tema no puede estar vacío")
    @Size(min = 3, max = 100, message = "El tema debe tener entre 3 y 100 caracteres")
    private String tema;

    @NotNull(message = "El docenteId es obligatorio")
    @Positive(message = "El docenteId debe ser un número positivo")
    private Long docenteId;

    @NotNull(message = "El comisionId es obligatorio")
    @Positive(message = "El comisionId debe ser un número positivo")
    private Long comisionId;

    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

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
