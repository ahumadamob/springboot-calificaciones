package com.imb2025.calificaciones.dto.request;

import com.imb2025.calificaciones.entity.enums.Estado;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MateriaRequestDto {
	
    @NotBlank(message="el nombre no puede estar vacio")
    private String nombre;
    
    @Size(min = 1, max = 4, message = "La materia debe tener entre 1 y 4 caracteres")
    private String codigo;
    
    @Min(value = 1, message = "La carga horaria debe tener minimo 1 horas catedras")
    @Max(value = 10, message = "La carga horaria debe tener como maximo 10 horas catedras")
    private Integer cargaHoraria;
    
    @NotBlank(message="el nivel debe ser especificado")
    private String nivel;
    
    @NotNull(message = "El estado no puede ser nulo")
    private Estado estado;

    public MateriaRequestDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
