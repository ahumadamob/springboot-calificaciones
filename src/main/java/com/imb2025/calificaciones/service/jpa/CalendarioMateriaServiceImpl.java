package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.Optional;

import com.imb2025.calificaciones.dto.CalendarioMateriaRequestDTO;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.CalendarioMateria;
import com.imb2025.calificaciones.repository.ICalendarioMateriaRepository;
import com.imb2025.calificaciones.service.ICalendarioMateriaService;

import jakarta.transaction.Transactional;

@Service
public class CalendarioMateriaServiceImpl implements ICalendarioMateriaService{

	@Autowired
	private ICalendarioMateriaRepository calMatRepo;
	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private ComisionRepository comisionRepository;

	@Override
	public List<CalendarioMateria> findAll() {
		return calMatRepo.findAll();
	}

	@Override
	@Transactional
	public CalendarioMateria findByID(Long id) {
		return calMatRepo.findById(id).orElseThrow(); 
	}

	@Override
	public CalendarioMateria create(CalendarioMateria calendarioMateria) {
		return calMatRepo.save(calendarioMateria);
	}

	@Override
	public CalendarioMateria update(Long id, CalendarioMateria calendarioMateria) throws Exception {

		if (calMatRepo.existsById(id)){
			calendarioMateria.setId(id);
			return calMatRepo.save(calendarioMateria);
		} else {
			throw new Exception ("No se encontro calendario materia con el id: "+ id);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {

		if (calMatRepo.existsById(id)){
			calMatRepo.deleteById(id);
		}

	}

	@Override
	public CalendarioMateria mapFromDto(CalendarioMateriaRequestDTO calMatDto) throws Exception {

		CalendarioMateria calendarioMateria = new CalendarioMateria();

		if (calMatDto.getFechaInicio().isAfter(calMatDto.getFechaFin())){
			throw new Exception("La fecha de inicio no puede ser posterior a la fecha de fin");
		}
		Materia materia = materiaRepository.findById(calMatDto.getMateriaId())
				.orElseThrow(() -> new Exception ("Materia no encontrada con el id: " + calMatDto.getMateriaId()));

		Comision comision = comisionRepository.findById(calMatDto.getComisionId())
				.orElseThrow(() -> new Exception ("Comision no encontrada con el id: " + calMatDto.getComisionId()));

		calendarioMateria.setFechaInicio(calMatDto.getFechaInicio());
		calendarioMateria.setFechaFin(calMatDto.getFechaFin());
		calendarioMateria.setMateria(materia);
		calendarioMateria.setComision(comision);

		return calendarioMateria;
	}


}
