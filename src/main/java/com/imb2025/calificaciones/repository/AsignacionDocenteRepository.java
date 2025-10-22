package com.imb2025.calificaciones.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.AsignacionDocente;

@Repository
public interface AsignacionDocenteRepository extends JpaRepository<AsignacionDocente, Long> {
    List<AsignacionDocente> findByDocenteId(Long docenteId);
    long countByMateriaIdAndComisionId(Long materiaId, Long comisionId);
}

