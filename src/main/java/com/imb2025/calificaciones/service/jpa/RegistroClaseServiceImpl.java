package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.RegistroClaseDTO;
import com.imb2025.calificaciones.entity.RegistroClase;

import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.repository.RegistroClaseRepository;
import com.imb2025.calificaciones.service.IRegistroClaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RegistroClaseServiceImpl implements IRegistroClaseService {
	
	private final  RegistroClaseRepository registroClaseRepository;
	private final DocenteRepository docenteRepository;
	private final ComisionRepository comisionRepository;
	
	

	public RegistroClaseServiceImpl(RegistroClaseRepository registroClaseRepository, DocenteRepository docenteRepository, ComisionRepository comisionRepository) {
		
		this.registroClaseRepository = registroClaseRepository;
        this.docenteRepository = docenteRepository;
        this.comisionRepository = comisionRepository;
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
	public void registrarClase(RegistroClaseDTO registro) {
		RegistroClase registroNuevo=new RegistroClase();
		registroNuevo.setComisionId(registro.getComisionId());
		registroNuevo.setDocenteId(registro.getDocenteId());
		registroNuevo.setFecha(LocalDate.now());
		registroNuevo.setTema(registro.getTema());
		registroClaseRepository.save(registroNuevo);
		
	}



	@Override
	public void eliminarRegistro(Long id) {
		registroClaseRepository.deleteById(id);
		
	}

	@Override
	public void validarIds(Long id, RegistroClaseDTO dto) {
		validarRegistro(id);
		validarDatos(dto);


	}

	private void validarRegistro(Long id){
		registroClaseRepository.findById(id).orElseThrow(()->new RuntimeException("no existe el registro"));
	}

	private void validarDatos(RegistroClaseDTO dto){
		comisionRepository.findById(dto.getComisionId()).orElseThrow(()->new RuntimeException("no existe esa comision con ese id"));
		docenteRepository.findById(dto.getDocenteId()).orElseThrow(()->new RuntimeException("no existe el docente con ese id"));
	}



}
