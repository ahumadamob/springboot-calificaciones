package com.imb2025.calificaciones.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.RegistroClase;

@Repository
public interface RegistroClaseRepository extends JpaRepository<RegistroClase,Long> {
    Optional<RegistroClase> findByComision_id(Long docenteId);

    Optional<RegistroClase> findByDocente_id(Long docenteId);
}
