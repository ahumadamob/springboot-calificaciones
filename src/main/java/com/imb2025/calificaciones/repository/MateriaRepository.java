package com.imb2025.calificaciones.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.enums.Estado;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
	
	public List<Materia>findByOrderByNombreAsc();
	public List<Materia>findByNivelEndingWithIgnoreCase(String sufijo);
	public Optional<Materia>findByCodigo(String codigo);
	long countByCargaHoraria(Integer cargahoraria);
	long countByEstado(Estado estado);
}

