package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.ObservacionAlumnoRequestDto;
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
	public ObservacionAlumno create(ObservacionAlumno observacionAlumno) {
		try {
			return observacionAlumnoRepository.save(observacionAlumno);
		} catch (Exception e) {
			throw new RuntimeException("error al crear la observación del alumno: " + e.getMessage());	 
		}
		 		
	}
	

	@Override
	public ObservacionAlumno update(Long id, ObservacionAlumno observacionAlumno) throws Exception {
		
		try {
			
			Optional<ObservacionAlumno> obs = observacionAlumnoRepository.findById(id); 
			
			if(obs != null) {	
				  observacionAlumno.setId(id);
				  return observacionAlumnoRepository.save(observacionAlumno);
			  } else {
				  throw new Exception("la observación de alumno no existe");
			  }  
			
		} catch (Exception e) {
			throw new RuntimeException("error al actualizar la observación del alumno: " + e.getMessage());	 
		}	  
	}
	

	@Override
	public void deleteById(Long id) {
		observacionAlumnoRepository.deleteById(id);
		
	}

	public ObservacionAlumno fromDTO(ObservacionAlumnoRequestDto dto) {
	    Docente docente = docenteRepository.findById(dto.getDocenteId())
	            .orElseThrow(() -> new RuntimeException("docente no encontrado"));

	    Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
	            .orElseThrow(() -> new RuntimeException("alumno no encontrado"));

	    ObservacionAlumno observacion = new ObservacionAlumno();
	    observacion.setFecha(dto.getFecha());
	    observacion.setTexto(dto.getTexto());
	    observacion.setDocente(docente);
	    observacion.setAlumno(alumno);

	    return observacion;
	}




	 

}
