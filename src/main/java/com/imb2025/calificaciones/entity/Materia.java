package com.imb2025.calificaciones.entity;

import com.imb2025.calificaciones.entity.enums.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;



@Entity 
public class Materia extends BaseEntity {

	    private String nombre;
        private String codigo;
        private Integer cargaHoraria;
        private String nivel;
        
        
        @Enumerated(EnumType.STRING) // 
        @Column(nullable = false)
        private Estado estado;
 

        public Materia() {
        }

        public Materia(String nombre, String codigo, Integer cargaHoraria, String nivel) {
                this.nombre = nombre;
                this.codigo = codigo;
                this.cargaHoraria = cargaHoraria;
                this.nivel = nivel;
        }
	
	
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
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
	
	public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    @PrePersist
    @Override
    protected void onCreate() {
        super.onCreate(); 
        if (this.estado == null) {
            this.estado = Estado.ACTIVO;
        }
    }


}
