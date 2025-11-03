package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    // Devuelve todas las carreras con nombre exacto
    List<Carrera> findByNombre(String nombre);

    // Devuelve carreras cuyo nombre contiene cierto texto, ignorando mayúsculas/minúsculas
    List<Carrera> findByNombreContainingIgnoreCase(String fragmento);

    // Devuelve la cantidad de carreras con un nombre específico
    long countByNombre(String nombre);

    // Verifica si existe una carrera con cierto nombre
    boolean existsByNombreIgnoreCase(String nombre);

}