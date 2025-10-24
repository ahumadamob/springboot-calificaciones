package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.CalendarioMateria;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICalendarioMateriaRepository extends JpaRepository<CalendarioMateria, Long> {

    List<CalendarioMateria> findByMateriaId(Long materiaId);
    Optional<Long> countByComisionId(Long comisionId);
    Optional<Long> countByEstado(CalendarioMateria.EstadoCalendarioMateria estadoCalendarioMateria);
}

