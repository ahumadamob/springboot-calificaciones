package com.imb2025.calificaciones.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.Nivel;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {

}
