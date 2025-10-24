package com.imb2025.calificaciones.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.enums.EstadoInscripcionMateria;

@Repository
public interface InscripcionMateriaRepository extends JpaRepository<InscripcionMateria, Long> {
    public List<InscripcionMateria> findByAlumno_Id(Long idAlumno);
    public long countByAlumno_Id(Long idAlumno);
    public List<InscripcionMateria> findByInscriptoTrue();
    public List<InscripcionMateria> findByInscriptoFalse();
    public Optional<InscripcionMateria> findByIdentificadorLegibleIgnoreCase(String identificadorLegible);
    public List<InscripcionMateria> findByFechaVigenciaGreaterThanEqual(LocalDate fecha);
    public List<InscripcionMateria> findByFechaVigenciaLessThan(LocalDate fecha);
    public long countByEstado(EstadoInscripcionMateria estado);

}

