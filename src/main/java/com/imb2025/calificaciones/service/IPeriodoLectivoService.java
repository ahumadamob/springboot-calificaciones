package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.PeriodoLectivoRequestDTO;
import com.imb2025.calificaciones.entity.PeriodoLectivo;

public interface IPeriodoLectivoService {
	List<PeriodoLectivo> findAll();
	PeriodoLectivo findById(Long id);
	Boolean existsById(Long id);
	PeriodoLectivo save(PeriodoLectivo periodoLectivo);
	PeriodoLectivo update(Long id, PeriodoLectivo periodoLectivo) throws Exception ;
	void deleteById(Long id) throws Exception ;
	PeriodoLectivo mapFromDTO(PeriodoLectivoRequestDTO requestDTO);
}
