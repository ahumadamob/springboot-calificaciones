package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Cursada;
import com.imb2025.calificaciones.repository.CursadaRepository;
import com.imb2025.calificaciones.service.ICursadaService;

@Service
public class CursadaServiceImpl implements ICursadaService{

	@Autowired
	
	private CursadaRepository repo;
	
	@Override
	public List<Cursada> findAll() {
		return repo.findAll();
	}

	@Override
	public Cursada findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Cursada save(Cursada cursada) {
		return repo.save(cursada) ;
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
