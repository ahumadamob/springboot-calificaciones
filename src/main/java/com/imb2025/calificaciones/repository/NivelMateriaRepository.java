package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.NivelMateria;

public interface NivelMateriaRepository extends JpaRepository<NivelMateria, Long> {

    // findBy...: filtra por nombre (contiene, ignore case)
    List<NivelMateria> findByNombreContainingIgnoreCase(String nombre);

    // countBy...: cuenta registros cuyo nombre contiene el texto
    long countByNombreContainingIgnoreCase(String nombre);

    // Métodos mágicos para filtrar por activo
    List<NivelMateria> findByActivoTrue();
    
    List<NivelMateria> findByActivoFalse();
}
	
	


