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
	@Transactional
	public CalendarioMateria save(CalendarioMateriaRequestDTO calendarioMateriaDto) {

		try {
			CalendarioMateria calendarioMateria = new CalendarioMateria();

			Materia materia = materiaRepository.findById(calendarioMateriaDto.getMateriaId())
					.orElseThrow(() -> new EntityNotFoundException
							("Materia no encontrada con el id: " + calendarioMateriaDto.getMateriaId()));


			Comision comision = comisionRepository.findById(calendarioMateriaDto.getComisionId())
					.orElseThrow(() -> new EntityNotFoundException
							("Comision no encontrada con el id: " + calendarioMateriaDto.getComisionId()));

			if (calendarioMateriaDto.getFechaInicio().isAfter(calendarioMateriaDto.getFechaFin())){
				throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
			}

			calendarioMateria.setMateria(materia);
			calendarioMateria.setComision(comision);
			calendarioMateria.setFechaInicio(calendarioMateriaDto.getFechaInicio());
			calendarioMateria.setFechaFin(calendarioMateriaDto.getFechaFin());
			return calMatRepo.save(calendarioMateria);
		} catch (EntityNotFoundException e) {
			throw e;
		}

	}
	
	@Override
	@Transactional
	public CalendarioMateria update(Long id, CalendarioMateriaRequestDTO calendarioMateriaDto) {

		try {
			CalendarioMateria existing = calMatRepo.findById(id)
					.orElseThrow(() -> new EntityNotFoundException
							("Calendario Materia no encontrado con el id: "+ id));

			Materia materia = materiaRepository.findById(calendarioMateriaDto.getMateriaId())
					.orElseThrow(() -> new EntityNotFoundException
							("Materia no encontrada con el id: " + calendarioMateriaDto.getMateriaId()));

			Comision comision = comisionRepository.findById(calendarioMateriaDto.getComisionId())
					.orElseThrow(() -> new EntityNotFoundException
							("Comision no encontrada con el id: " + calendarioMateriaDto.getComisionId()));


			if (calendarioMateriaDto.getFechaInicio().isAfter(calendarioMateriaDto.getFechaFin())){
				throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
			}

			existing.setFechaInicio(calendarioMateriaDto.getFechaInicio());
			existing.setFechaFin(calendarioMateriaDto.getFechaFin());
			existing.setMateria(materia);
			existing.setComision(comision);

			return calMatRepo.save(existing);
		} catch (EntityNotFoundException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {

		if (calMatRepo.existsById(id)){
			calMatRepo.deleteById(id);
		}
	
	}



}
