package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.Comision;

public interface ComisionRepository extends JpaRepository<Comision, Long> {

    // Filtra comisiones cuyo nombre contiene el texto (case-insensitive)
    List<Comision> findByNombreContainingIgnoreCase(String nombre);

    // Cuenta comisiones que pertenecen a una sede (por id de sede)
    long countBySedeId(Long sedeId);
    
    java.util.List<Comision> findByDestacadoTrue();

    java.util.List<Comision> findByDestacadoFalse();
}

