package com.imb2025.calificaciones.dto.response;

import java.time.LocalDate;

public class ProductoResponseDto {
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
    
    private LocalDate fechaVigencia;
    private Integer version;

   
    public ProductoResponseDto() {}

   
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Double getPrecio() { return precio; }
    public Integer getStock() { return stock; }
    public LocalDate getFechaVigencia() { return fechaVigencia; }
    public Integer getVersion() { return version; }

    
    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public void setStock(Integer stock) { this.stock = stock; }
    public void setFechaVigencia(LocalDate fechaVigencia) { this.fechaVigencia = fechaVigencia; }
    public void setVersion(Integer version) { this.version = version; }
}