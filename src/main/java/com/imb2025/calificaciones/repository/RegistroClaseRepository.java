package com.imb2025.calificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imb2025.calificaciones.entity.RegistroClase;

@Repository
public interface RegistroClaseRepository extends JpaRepository<RegistroClase,Long> {

}
