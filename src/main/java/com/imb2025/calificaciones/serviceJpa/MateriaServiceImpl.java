package com.imb2025.calificaciones.serviceJpa;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.service.IMateriaService;


@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private MateriaRepository repo;

	@Override
	public List<Materia> findAll() {
		
		return repo.findAll();
		
	}

	@Override
	public Materia findById(Long id) {
	
		
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public Materia save(Materia materia) {
		
		return repo.save(materia);
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
		
	}
}
