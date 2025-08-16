package com.imb2025.calificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoEvaluacion {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nombre;
        private String descripcion;

        public TipoEvaluacion() {
        }

        public TipoEvaluacion(long id, String nombre, String descripcion) {
                this.id = id;
                this.nombre = nombre;
                this.descripcion = descripcion;
        }

        public TipoEvaluacion(String nombre, String descripcion) {
                this.nombre = nombre;
                this.descripcion = descripcion;
        }

        public long getId() {
                return id;
        }
        public void setId(long id) {
                this.id = id;
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
