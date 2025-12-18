package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;

@Entity
public class TipoEvaluacion extends BaseEntity{

        private String nombre;
        private String descripcion;
        private TipoEvaluacionEnum categoria = TipoEvaluacionEnum.ALTA;
                
        //Constructor
		public TipoEvaluacion() {
			super();
		}		
		
		public TipoEvaluacion(String nombre, String descripcion, TipoEvaluacionEnum categoria) {
			super();
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.categoria = categoria;
		}

		
		//Getter and Setter
		
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

		public TipoEvaluacionEnum getCategoria() {
			return categoria;
		}

		public void setCategoria(TipoEvaluacionEnum categoria) {
			this.categoria = categoria;
		}
		
/*
		public enum TipoEvaluacionEnum {
			ALTA,
			MEDIA,
			BAJA
	}		
		
*/
}