package com.imb2025.calificaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioServiceImpl implements HorarioServices{

	@Autowired
	private HorarioRepository horarioRepository;
	
	@Override
	public List<Horario> getAll() {
		
		return horarioRepository.findAll();
	}

	@Override
	public Horario save(Horario nuevoHorario) {
		
		return horarioRepository.save(nuevoHorario);
	}

	@Override
	public Horario update(Long id, Horario datosActualizados) {
		
		return horarioRepository.save(datosActualizados);
	}

	@Override
	public void delete(Long id) {
		
		horarioRepository.deleteById(id);
		
	}

	@Override
	public Horario findById(Long id) {
		
		return horarioRepository.findById(id).orElse(null);
	}

}
