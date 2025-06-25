package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.AlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.service.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class AlumnoServicesImpl implements IAlumnoServices {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Alumno update(Long id, AlumnoRequestDTO datosActualizados) throws Exception {
        if (alumnoRepository.existsById(id)) {
            return mapFromDTO(datosActualizados);
        } else {
            throw new Exception("Estudiante no encontrado");
        }
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return alumnoRepository.existsById(id);
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Override
    public Alumno create(AlumnoRequestDTO nuevoAlumno) {
        return mapFromDTO(nuevoAlumno);
       
    }

    @Override
    public void deleteById(Long id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Estudiante no encontrado");
        }
    }
     @Override
    public Alumno mapFromDTO(AlumnoRequestDTO alumnoDto) {
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
        alumnoRepository.save(alumno);
        return alumno;
    }
    }

