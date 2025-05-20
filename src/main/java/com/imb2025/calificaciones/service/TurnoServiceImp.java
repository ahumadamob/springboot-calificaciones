package com.imb2025.calificaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.repository.TurnoRepository;

@Service
public class TurnoServiceImp implements TurnoService {
	
	@Autowired
	private TurnoRepository turnoRepository;

	@Override
	public List<Turno> findAll() {
		return turnoRepository.findAll();
	}

	@Override
	public Turno findById(Long id) {
		return turnoRepository.findById(id).orElse(null);

	}

	@Override
	public Turno save(Turno turno) {
		return turnoRepository.save(turno);

	}

	@Override
	public Turno update(Long id, Turno turno) {
		turno.setId(id);
		return turnoRepository.save(turno);
	}

	@Override
	public void deleteById(Long id) {
		turnoRepository.deleteById(id);
	}
	

}
