package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.ObservacionAlumno;
import com.imb2025.calificaciones.entity.ObservacionAlumno.Categoria;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.repository.ObservacionAlumnoRepository;
import com.imb2025.calificaciones.service.IObservacionAlumnoService;

@Service
public class ObservacionAlumnoServiceImpl implements IObservacionAlumnoService{

    private static final boolean List = false;
	@Autowired
    private ObservacionAlumnoRepository observacionAlumnoRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private DocenteRepository docenteRepository;


    @Override
    public ObservacionAlumno findById(Long id) {
        return observacionAlumnoRepository.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException(
        				"observación no encontrada con id " + id));
    }

    @Override
    public List<ObservacionAlumno> findAll() {
        return observacionAlumnoRepository.findAll();
    }

    @Override
    public ObservacionAlumno create(ObservacionAlumno observacionAlumno, Long alumnoId, Long docenteId) {
        
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Docente docente = docenteRepository.findById(docenteId)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        observacionAlumno.setAlumno(alumno);
        observacionAlumno.setDocente(docente);

        return observacionAlumnoRepository.save(observacionAlumno);
       
    }

    
    @Override
    public ObservacionAlumno update(ObservacionAlumno observacionAlumno, Long id, Long alumnoId, Long docenteId) {

        ObservacionAlumno existente = observacionAlumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Observación no encontrada"));

        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Docente docente = docenteRepository.findById(docenteId)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        existente.setTexto(observacionAlumno.getTexto());
        existente.setFecha(observacionAlumno.getFecha());
        existente.setAlumno(alumno);
        existente.setDocente(docente);

        return observacionAlumnoRepository.save(existente);
    }



    @Override
    public void deleteById(Long id) throws Exception {
        if (!observacionAlumnoRepository.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        observacionAlumnoRepository.deleteById(id);
    }
    

	@Override
	public List<ObservacionAlumno> findByDocente(Docente docente) {
		return observacionAlumnoRepository.findByDocente(docente);
	}

	@Override
	public Long countByAlumno(Alumno alumno) {
		return observacionAlumnoRepository.countByAlumno(alumno);
	}


	@Override
	public List<ObservacionAlumno> findByCategoria(Categoria categoria) {
		
		List<ObservacionAlumno> observacion = 
				observacionAlumnoRepository.findByCategoria(categoria);		
	


		return observacion;
			
		

	}

}
