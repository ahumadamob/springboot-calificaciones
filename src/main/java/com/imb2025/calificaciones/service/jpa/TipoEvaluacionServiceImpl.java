package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.repository.TipoEvaluacionRepository;
import com.imb2025.calificaciones.service.ITipoEvaluacionService;

@Service
public class TipoEvaluacionServiceImpl implements ITipoEvaluacionService{

	@Autowired
	private TipoEvaluacionRepository repo;
		
	
	@Override
		public List<TipoEvaluacion> findAll() {
		return repo.findAll();
	}

	@Override
	public TipoEvaluacion findById(Long id) {
		
		Optional<TipoEvaluacion> optional;
		optional = repo.findById(id);
		if(optional.isPresent()) {
			return (TipoEvaluacion) optional.get();
		}else {
			return null;
		}
	}

	@Override
	public TipoEvaluacion save(TipoEvaluacion tipoevaluacion) {
		return repo.save(tipoevaluacion);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	
	
	
	

}
