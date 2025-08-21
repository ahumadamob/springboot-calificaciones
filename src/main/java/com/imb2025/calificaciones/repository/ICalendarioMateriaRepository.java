package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.CalendarioMateria;

@Repository
public interface ICalendarioMateriaRepository extends JpaRepository<CalendarioMateria, Long> {
}

