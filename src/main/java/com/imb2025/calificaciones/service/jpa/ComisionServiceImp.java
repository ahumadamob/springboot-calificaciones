package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.ComisionRequestDTO;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Sede;
import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.SedeRepository;
import com.imb2025.calificaciones.repository.TurnoRepository;
import com.imb2025.calificaciones.service.IComisionService;

@Service 
public class ComisionServiceImp implements IComisionService{

	@Autowired
	private ComisionRepository repository;
	
	@Autowired
	private TurnoRepository repositoryTurno;
	
	@Autowired
	private SedeRepository repositorySede;
	
	@Override
	public List<Comision> findAll() {
		 return repository.findAll();
	}

	@Override
	public Comision findById(Long id) {
		 return repository.findById(id).orElse(null);
	}

	@Override
	public Comision create(Comision Comision) {
		 return repository.save(Comision);
	}

	@Override
	public Comision update(Long id, Comision Comision) throws Exception {
		if(repository.existsById(id)) {
		Comision.setId(id);
		return repository.save(Comision);
		}else {
			throw new Exception("No se encontro comision con id" + id);
		}
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Comision mapFromDto(ComisionRequestDTO comisionRequestDTO) throws Exception {
		Comision comision = new Comision();
		comision.setNombre(comisionRequestDTO.getNombre());
		
		
		Turno turno = repositoryTurno.findById(comisionRequestDTO.getTurnoId())
				.orElseThrow(() -> new Exception ("Turno no encontrado")); 	
		comision.setTurno(turno);
		
		Sede sede = repositorySede.findById(comisionRequestDTO.getSedeId())
		.orElseThrow(() -> new Exception ("Sede no encontrado"));
		
		comision.setSede(sede);
		
		return comision;
	}
}
