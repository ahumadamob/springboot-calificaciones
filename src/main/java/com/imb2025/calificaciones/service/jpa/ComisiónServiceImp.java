package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Comisión;
import com.imb2025.calificaciones.repository.ComisiónRepository;
import com.imb2025.calificaciones.service.IComisiónService;

@Service 
public class ComisiónServiceImp implements IComisiónService{

	@Autowired
	private ComisiónRepository repository;
	
	@Override
	public List<Comisión> findAll() {
		 return repository.findAll();
	}

	@Override
	public Comisión findById(Long id) {
		 return repository.findById(id).orElse(null);
	}

	@Override
	public Comisión save(Comisión Comisión) {
		 return repository.save(Comisión);
	}

	@Override
	public Comisión update(Long id, Comisión Comisión) {
		Comisión.setId(id);
        return repository.save(Comisión);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}
}
