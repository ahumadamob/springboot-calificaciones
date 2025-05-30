package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imb2025.calificaciones.entity.Carrera;
import com.imb2025.calificaciones.repository.CarreraRepository;
import com.imb2025.calificaciones.service.ICarreraService;

@Service
public class CarreraServiceImp implements ICarreraService {

   
	 @Autowired
	    private CarreraRepository repo;

    
	@Override
	public List<Carrera> findAll() {
		
	return repo.findAll();
	
	}

	@Override
	public Carrera findById(Long id) {
		
		return repo.findById(id).orElse(null);
	}
	
	@Override
	public Carrera save(Carrera carrera) {

			return repo.save(carrera);
	}

	@Override
	public void deleteById(Long id) {
		
		repo.deleteById(id);
		
	}

}