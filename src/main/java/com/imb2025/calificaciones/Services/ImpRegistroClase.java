package com.imb2025.calificaciones.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.Entity.RegistroClase;
import com.imb2025.calificaciones.Repository.RegistroClaseRepository;

@Service
public class ImpRegistroClase implements IRegistroClaseService {
	
	private final  RegistroClaseRepository registroClaseRepository;
	
	

	public ImpRegistroClase(RegistroClaseRepository registroClaseRepository) {
		
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
