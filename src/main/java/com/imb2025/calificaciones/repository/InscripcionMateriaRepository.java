package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.InscripcionMateria;

@Repository
public interface InscripcionMateriaRepository extends JpaRepository<InscripcionMateria, Long> {
    public List<InscripcionMateria> findByAlumno_Id(Long idAlumno);
    public long countByAlumno_Id(Long idAlumno);
}

