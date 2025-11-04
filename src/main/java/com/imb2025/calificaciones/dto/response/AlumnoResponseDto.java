package com.imb2025.calificaciones.dto.response;

public class AlumnoResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    // Campo requerido en la consigna
    private Long version;
    private Boolean atributoBooleano;

    public AlumnoResponseDto() {}

    public AlumnoResponseDto(Long id, String nombre, String apellido, String email, int dni, Long version, Boolean atributoBooleano) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.version = version;
        this.atributoBooleano = atributoBooleano;
    }

    // Getters y Setters
    public Boolean getAtributoBooleano() {
        return atributoBooleano;
    }

    public void setAtributoBooleano(Boolean atributoBooleano) {
        this.atributoBooleano = atributoBooleano;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}