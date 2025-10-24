package com.imb2025.calificaciones.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ProductoRequestDto {

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    @NotNull(message = "El precio no puede ser nulo.")
    private Double precio;

    @NotNull(message = "El stock no puede ser nulo.")
    private Integer stock;

    
    @NotNull(message = "La fecha de vigencia no puede ser nula.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "El formato de la fecha de vigencia debe ser AAAA-MM-DD.")
    private String fechaVigencia;


    public ProductoRequestDto() {}

    
    public String getNombre() { return nombre; }
    public Double getPrecio() { return precio; }
    public Integer getStock() { return stock; }
    public String getFechaVigencia() { return fechaVigencia; }

  
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public void setStock(Integer stock) { this.stock = stock; }
    public void setFechaVigencia(String fechaVigencia) { this.fechaVigencia = fechaVigencia; }
}