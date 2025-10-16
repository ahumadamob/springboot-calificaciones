package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.EstadoEvaluacion;

public interface EstadoEvaluacionRepository extends JpaRepository<EstadoEvaluacion, Long> {

    List<EstadoEvaluacion> findByNombreIgnoreCase(String nombre);
    long countByDescripcion(String descripcion);
}

