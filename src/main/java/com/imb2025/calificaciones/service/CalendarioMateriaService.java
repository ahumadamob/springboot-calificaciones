package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.CalendarioMateria;
import com.imb2025.calificaciones.repository.ICalendarioMateriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CalendarioMateriaService implements ICalendarioMateriaService{

	@Autowired
	private ICalendarioMateriaRepository calMatRepo;
	
	@Override
	@Transactional
	public List<CalendarioMateria> findAll() {
		return calMatRepo.findAll();
	}

	@Override
	@Transactional
	public CalendarioMateria findByID(Long id) {
		return calMatRepo.findById(id).orElseThrow(); 
	}

	@Override
	@Transactional
	public CalendarioMateria save(CalendarioMateria calendarioMateria) {
		return calMatRepo.save(calendarioMateria);
	}
	
	@Override
	@Transactional
	public CalendarioMateria update(Long id, CalendarioMateria calendarioMateria) {
		calendarioMateria.setId(id);
		return calMatRepo.save(calendarioMateria);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		if (calMatRepo.existsById(id)){
			calMatRepo.deleteById(id);
		}
	
	}



}
