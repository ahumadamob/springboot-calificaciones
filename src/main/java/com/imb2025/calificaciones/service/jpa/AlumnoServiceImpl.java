package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.AlumnoRequestDto;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.service.IAlumnoService;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Alumno update(Alumno alumno, Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
        }
        alumno.setId(id);
        return alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Entidad no encontrada con id " + id));    
    }

    @Override
    public Alumno create(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void deleteById(Long id) {
          if (!alumnoRepository.existsById(id)) {
              throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
          }
          alumnoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return alumnoRepository.existsById(id);
    }

    @Override
    public Alumno fromDto(AlumnoRequestDto alumnoDto){
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDto.getNombre());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setEmail(alumnoDto.getEmail());
        alumno.setDni(alumnoDto.getDni());
        try {
            alumno.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(alumnoDto.getFechaNacimiento()));
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de fecha incorrecto. Se espera yyyy-MM-dd.");
        }
        return alumno;
    }
}

