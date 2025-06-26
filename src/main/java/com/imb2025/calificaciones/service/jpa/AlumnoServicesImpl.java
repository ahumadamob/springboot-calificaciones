package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.DTO.AlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.service.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class AlumnoServicesImpl implements IAlumnoServices {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno create(Alumno alumno) {
        return alumnoRepository.save(alumno);
    
    }

    @Override
    public Alumno update(Long id, Alumno alumno) throws Exception {
        if(alumnoRepository.existsById(id)){
            alumno.setId(id);
            return alumnoRepository.save(alumno);
        }else {
            throw new Exception("Alumno con ID " + id + " no encontrado.");
        }

    }

   

    

    @Override
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
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
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de fecha incorrecto. Se espera yyyy-MM-dd.");
        }
        return alumno;
    }
}
