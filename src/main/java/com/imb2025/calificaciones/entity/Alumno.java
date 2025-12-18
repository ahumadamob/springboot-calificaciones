package com.imb2025.calificaciones.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Alumno extends BaseEntity {

    private String nombre;
    private String apellido;
    private int dni;
    private String email;
    private Date fechaNacimiento ; // Tipo Date para recibir el resultado del Mapper
    private Boolean atributoBooleano = false;
    private LocalDate fechaBaja;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, int dni, String email, Date fechaNacimiento, Boolean atributoBooleano, LocalDate fechaBaja) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.atributoBooleano = atributoBooleano;
        this.fechaBaja= fechaBaja;
    }

    // Getters y Setters

    public Boolean getAtributoBooleano() {
        return atributoBooleano;
    }

    public void setAtributoBooleano(Boolean atributoBooleano) {
        this.atributoBooleano = atributoBooleano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}