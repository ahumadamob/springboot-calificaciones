package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.AsistenciaRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Asistencia;
import com.imb2025.calificaciones.entity.RegistroClase;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.repository.AsistenciaRepository;
import com.imb2025.calificaciones.repository.RegistroClaseRepository;
import com.imb2025.calificaciones.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private RegistroClaseRepository registroClaseRepository;

    @Override
    public List<Asistencia> findAll() {
        return asistenciaRepository.findAll();
    }

    @Override
    public Asistencia findById(Long id) {
        return asistenciaRepository.findById(id).orElse(null);
    }

    @Override
    public Asistencia save(AsistenciaRequestDTO dto) throws Exception {
        try {
        	Asistencia asistencia = new Asistencia();
			if(dto.getAlumnoId() != null) {
            	Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
                    .orElse(null);
            	if(alumno == null) {
            		throw new RuntimeException("Alumno no encontrado");
            	}
            	asistencia.setAlumno(alumno);
            } 
            	
            System.out.println("Despues de alumno");   
            if(dto.getRegistroClaseId() != null) {
            	RegistroClase registro = registroClaseRepository.findById(dto.getRegistroClaseId())
                    .orElse(null);
            	if(registro == null) {
            		throw new RuntimeException("Registro no encontrado");
            	}
            	asistencia.setRegistroClase(registro);
            }          
            asistencia.setPresente(dto.getPresente());

            return asistenciaRepository.save(asistencia);
            }
            catch (Exception e) {
            throw new Exception("Error al guardar la asistencia: " + e.getMessage());
        }
    }

    @Override
    public Asistencia update(Long id, AsistenciaRequestDTO dto) throws Exception {
        Optional<Asistencia> asistenciaOpt = asistenciaRepository.findById(id);
        
        if (asistenciaOpt.isEmpty()) {
            throw new Exception("No se encontró la asistencia con ID: " + id);
        }

        try {
        	Asistencia asistencia = asistenciaOpt.get();
        	if(dto.getAlumnoId() != null) {
            	Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
                    .orElse(null);
            	if(alumno == null) {
            		throw new RuntimeException("Alumno no encontrado");
            	}
            	asistencia.setAlumno(alumno);
            } 
            	
            System.out.println("Despues de alumno");   
            if(dto.getRegistroClaseId() != null) {
            	RegistroClase registro = registroClaseRepository.findById(dto.getRegistroClaseId())
                    .orElse(null);
            	if(registro == null) {
            		throw new RuntimeException("Registro no encontrado");
            	}
            	asistencia.setRegistroClase(registro);
            }                    
                        
            asistencia.setPresente(dto.getPresente());

            return asistenciaRepository.save(asistencia);
        } catch (Exception e) {
            throw new Exception("Error al actualizar la asistencia: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!asistenciaRepository.existsById(id)) {
            throw new Exception("No se encontró la asistencia con ID: " + id);
        }

        try {
            asistenciaRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar la asistencia: " + e.getMessage());
        }
    }
}
