package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.RequisitoMateria;
import com.imb2025.calificaciones.repository.RequisitoMateriaRepository;
import com.imb2025.calificaciones.service.IRequisitoMateriaService;

@Service
public class RequisitoMateriaServiceImpl implements IRequisitoMateriaService {
	
	@Autowired
	private RequisitoMateriaRepository repo;

	@Override
	public List<RequisitoMateria> findAll() {
		return repo.findAll();
	}

	@Override
	public RequisitoMateria findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public RequisitoMateria save(RequisitoMateria requisito) {
		return repo.save(requisito);
	}

	@Override
	public RequisitoMateria update(Long id, RequisitoMateria requisito) {
		
		// TODO Método a completar correctamente
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Método a completar correctamente		
	}

}
