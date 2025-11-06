package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;

@Entity
public class TipoEvaluacion extends BaseEntity{

        private String nombre;
        private String descripcion;


        public TipoEvaluacion() {
        }

		public TipoEvaluacion(String nombre, String descripcion) {
			super();
			this.nombre = nombre;
			this.descripcion = descripcion;
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