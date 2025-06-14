package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.DTO.AlumnoRequestDTO;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.service.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Alumno saveFromDTO(AlumnoRequestDTO dto) {
        try {
            Alumno alumno = mapToEntity(dto);
            return alumnoRepository.save(alumno);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el alumno: " + e.getMessage());
        }
    }

    @Override
    public Alumno updateFromDTO(Long id, AlumnoRequestDTO dto) {
        try {
            Alumno existente = alumnoRepository.findById(id).orElse(null);
            if (existente == null) return null;
            existente.setNombre(dto.getNombre());
            existente.setApellido(dto.getApellido());
            existente.setEmail(dto.getEmail());
            existente.setDni(dto.getDni());
            existente.setFechaNacimiento(parseFecha(dto.getFechaNacimiento()));
            return alumnoRepository.save(existente);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el alumno: " + e.getMessage());
        }
    }

    private Alumno mapToEntity(AlumnoRequestDTO dto) {
        Alumno alumno = new Alumno();
        alumno.setNombre(dto.getNombre());
        alumno.setApellido(dto.getApellido());
        alumno.setEmail(dto.getEmail());
        alumno.setDni(dto.getDni());
        alumno.setFechaNacimiento(parseFecha(dto.getFechaNacimiento()));
        return alumno;
    }

    private Date parseFecha(String fecha) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de fecha incorrecto. Se espera yyyy-MM-dd.");
        }
    }

    @Override
    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }
}
