package com.imb2025.calificaciones.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class NivelMateriaRequestDto {


@NotBlank(message = "El nombre es obligatorio")
@Size(min = 2, max = 100, message = "El nombre debe tener entre {min} y {max} caracteres")
private String nombre;


@Size(max = 250, message = "La descripción no puede superar {max} caracteres")
private String descripcion;


public NivelMateriaRequestDto() {
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
}