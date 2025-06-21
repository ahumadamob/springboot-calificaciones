package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.TurnoRequestDTO;
import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.repository.TurnoRepository;
import com.imb2025.calificaciones.service.ITurnoService;

@Service
public class TurnoServiceImp implements ITurnoService {
	
	@Autowired
	private TurnoRepository turnoRepository;

	@Override
	public List<Turno> findAll() {
		return turnoRepository.findAll();
	}

	@Override
	public Turno findById(Long id) {
		return turnoRepository.findById(id).orElse(null);

	}

	@Override
	public Turno create (Turno turno) {
		return turnoRepository.save(turno);

	}

	@Override
	public Turno update(Long id, Turno turno) throws Exception {
		if(turnoRepository.existsById(id)) {
			turno.setId(id);
			return turnoRepository.save(turno);
		}else {
			
			throw new Exception("No se encontro Turno con id: " + id);
		}
	}

	@Override
	public void deleteById(Long id) {
		turnoRepository.deleteById(id);
	}

	@Override
	public Turno mapFromDTO(TurnoRequestDTO turnoRequestDTO) {
		Turno turno = new Turno();
		turno.setNombre(turnoRequestDTO.getNombre());
		turno.setHoraInicio(turnoRequestDTO.getHoraInicio());
		turno.setHoraFin(turnoRequestDTO.getHoraFin());
		return turno;
	}
	
	
	

}
