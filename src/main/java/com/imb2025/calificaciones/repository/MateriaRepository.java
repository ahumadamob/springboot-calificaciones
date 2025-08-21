package com.imb2025.calificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
}

