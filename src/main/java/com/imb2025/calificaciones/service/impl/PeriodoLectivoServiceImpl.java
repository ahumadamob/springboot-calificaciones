package com.imb2025.calificaciones.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.repository.PeriodoLectivoRepository;
import com.imb2025.calificaciones.service.PeriodoLectivoService;

@Service
public class PeriodoLectivoServiceImpl implements PeriodoLectivoService{
	
	@Autowired
	private PeriodoLectivoRepository repository;
	
	@Override
	public List<PeriodoLectivo> findAll() {
		return repository.findAll();
	}

	@Override
	public PeriodoLectivo findById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public PeriodoLectivo save(PeriodoLectivo periodoLectivo) {
		return repository.save(periodoLectivo);
	}

	@Override
	public PeriodoLectivo update(Long id, PeriodoLectivo periodoLectivo) {
		periodoLectivo.setId(id);
		return repository.save(periodoLectivo);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
