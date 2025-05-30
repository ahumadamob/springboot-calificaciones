package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.RegistroClase;
import com.imb2025.calificaciones.repository.RegistroClaseRepository;
import com.imb2025.calificaciones.service.IRegistroClaseService;

@Service
public class RegistroClaseServiceImpl implements IRegistroClaseService {
	
	private final  RegistroClaseRepository registroClaseRepository;
	
	

	public RegistroClaseServiceImpl(RegistroClaseRepository registroClaseRepository) {
		
		this.registroClaseRepository = registroClaseRepository;
	}



	@Override
	public List<RegistroClase> obtenerTodosLosRegistros() {
		return registroClaseRepository.findAll();
		
	}



	@Override
	public RegistroClase obtenerRegistro(Long id) {
		
		 return registroClaseRepository.findById(id).orElse(null);
	}



	@Override
	public void registrarClase(RegistroClase registro) {
		registroClaseRepository.save(registro);
		
	}



	@Override
	public void eliminarRegistro(Long id) {
		registroClaseRepository.deleteById(id);
		
	}

	
}
