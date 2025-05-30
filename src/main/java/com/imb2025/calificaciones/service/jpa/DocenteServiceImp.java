package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.service.IDocenteService;


@Service
public class DocenteServiceImp implements IDocenteService {
	

	@Autowired
	private DocenteRepository repo ;
	
	
	
	
	@Override
	public List<Docente> findAll() {
		return repo.findAll();
	
		
	}

	@Override
	public Docente findById(Long id) {
		
		return repo.findById(id).orElse(null);
		
		
	}

	@Override
	public Docente save(Docente docente) {
		return repo.save(docente);
	}
	
	@Override
	public void deleteById(Long id) {
		
		repo.deleteById(id);
		
		
	}
	
	
	
	

}
