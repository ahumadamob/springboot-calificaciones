package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.PeriodoLectivo;

public interface IPeriodoLectivoService {
	List<PeriodoLectivo> findAll();
	PeriodoLectivo findById(Long id);
	PeriodoLectivo save(PeriodoLectivo periodoLectivo);
	PeriodoLectivo update(Long id, PeriodoLectivo periodoLectivo);
	void deleteById(Long id);
}
