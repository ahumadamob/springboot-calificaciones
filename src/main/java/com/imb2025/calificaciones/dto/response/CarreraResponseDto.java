package com.imb2025.calificaciones.dto.response;

public class CarreraResponseDto {

    private Long id;
    private String nombre;
    private String tituloOtorgado;
    private Long version;

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

    public String getTituloOtorgado() {
        return tituloOtorgado;
    }

    public void setTituloOtorgado(String tituloOtorgado) {
        this.tituloOtorgado = tituloOtorgado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}