package com.imb2025.calificaciones.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public class NivelMateriaRequestDto {


@NotBlank(message = "El nombre es obligatorio")
@Size(min = 2, max = 100, message = "El nombre debe tener entre {min} y {max} caracteres")
private String nombre;


@Size(max = 250, message = "La descripción no puede superar {max} caracteres")
private String descripcion;

@Pattern(regexp = "^[a-zA-Z0-9]{3,10}$", message = "El código debe tener entre 3 y 10 caracteres alfanuméricos")
private String codigo;

@Positive(message = "El valor debe ser positivo")
private int cantidad;

@Min(value = 0, message = "El valor no puede ser negativo")
private int stockDisponible;

@Email(message = "El correo electrónico debe ser válido")
private String email;

@PastOrPresent(message = "La fecha no puede ser futura")
private LocalDate fechaCreacion;

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