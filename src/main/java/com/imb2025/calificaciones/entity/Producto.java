package com.imb2025.calificaciones.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import java.time.LocalDate;

@Entity
public class Producto {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String nombre;
 private Double precio;
 private Integer stock;


 @Column(nullable = false)
 private LocalDate fechaVigencia;

 @Version
 private Integer version;

 
 public Producto() {}

 public Producto(Long id, String nombre, Double precio, Integer stock, LocalDate fechaVigencia, Integer version) {
     this.id = id;
     this.nombre = nombre;
     this.precio = precio;
     this.stock = stock;
     this.fechaVigencia = fechaVigencia;
     this.version = version;
 }


 public Long getId() {
     return id;
 }

 public String getNombre() {
     return nombre;
 }

 public Double getPrecio() {
     return precio;
 }

 public Integer getStock() {
     return stock;
 }

 public LocalDate getFechaVigencia() {
     return fechaVigencia;
 }

 public Integer getVersion() {
     return version;
 }


 public void setId(Long id) {
     this.id = id;
 }

 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 public void setPrecio(Double precio) {
     this.precio = precio;
 }

 public void setStock(Integer stock) {
     this.stock = stock;
 }

 public void setFechaVigencia(LocalDate fechaVigencia) {
     this.fechaVigencia = fechaVigencia;
 }

 public void setVersion(Integer version) {
     this.version = version;
 }
}