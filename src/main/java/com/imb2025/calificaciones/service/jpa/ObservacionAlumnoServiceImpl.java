package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.ObservacionAlumno;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.repository.ObservacionAlumnoRepository;
import com.imb2025.calificaciones.service.IObservacionAlumnoService;

@Service
public class ObservacionAlumnoServiceImpl implements IObservacionAlumnoService{
	
	@Autowired
	private ObservacionAlumnoRepository observacionAlumnoRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private DocenteRepository docenteRepository;

	@Override
	public Optional<ObservacionAlumno> findById(Long id) {
		// TODO Auto-generated method stub
		return observacionAlumnoRepository.findById(id);
	}

	@Override
	public List<ObservacionAlumno> findAll() {
		// TODO Auto-generated method stub
		return observacionAlumnoRepository.findAll();
	}

	@Override
	public ObservacionAlumno save(ObservacionAlumnoRequestDTO dto) {
		
		try {
			
			ObservacionAlumno observacionAlumno = new ObservacionAlumno();
			
			Docente docente = docenteRepository.findById(dto.getDocenteId())
					.orElse(null);
			Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
					.orElse(null);
			
			if (alumno == null) {
				throw new RuntimeException("alumno no encontrado");
			}
			if (docente == null) {
				throw new RuntimeException("docente no encontrado");
			}
			
			observacionAlumno.setAlumno(alumno);
			observacionAlumno.setDocente(docente);
			observacionAlumno.setFecha(dto.getFecha());
			observacionAlumno.setTexto(dto.getTexto());
			
			return observacionAlumnoRepository.save(observacionAlumno);
			
		} catch (Exception e) {
			throw new RuntimeException("error al guardar la observación del alumno: " + e.getMessage());
		}		
	}
	

	@Override
	public ObservacionAlumno update(Long id, ObservacionAlumnoRequestDTO dto) {
		 try {
			 
			ObservacionAlumno observacionAlumno = observacionAlumnoRepository.findById(id)
					.orElse(null);
			Docente docente = docenteRepository.findById(dto.getDocenteId())
					.orElse(null);
			Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
					.orElse(null);
			 
			if (observacionAlumno == null) {		 
				 throw new RuntimeException("observación no encontrada");		
			}
				
			if (alumno == null) {
				throw new RuntimeException("alumno no encontrado");
			}
			
			if (docente == null) {
				throw new RuntimeException("docente no encontrado");
			}
			
			observacionAlumno.setAlumno(alumno);
			observacionAlumno.setDocente(docente);
			observacionAlumno.setFecha(dto.getFecha());
			observacionAlumno.setTexto(dto.getTexto());
			
			return observacionAlumnoRepository.save(observacionAlumno);
	
		} catch (Exception e) {
			throw new RuntimeException("error al actualizar la observación del alumno: " + e.getMessage());		}
	}
	

	@Override
	public void deleteById(Long id) {
		observacionAlumnoRepository.deleteById(id);
		
	}

	 

}
