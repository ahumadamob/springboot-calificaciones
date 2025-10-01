package com.imb2025.calificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ObraSocialRequestDto {

    @NotBlank(message = "El nombre de la obra social es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    private String descripcion;

    @Size(max = 30, message = "El teléfono no puede superar los 30 caracteres")
    @Pattern(regexp = "^[0-9+\\-\\s]*$", message = "El teléfono solo puede contener números, espacios y los símbolos + o -")
    private String telefonoContacto;

    public ObraSocialRequestDto() {
    }

    public ObraSocialRequestDto(String nombre, String descripcion, String telefonoContacto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefonoContacto = telefonoContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}
