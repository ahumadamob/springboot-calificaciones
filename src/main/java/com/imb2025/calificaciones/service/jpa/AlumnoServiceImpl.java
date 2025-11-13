package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.service.IAlumnoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    @Transactional
    public Alumno update(Alumno alumnoParaActualizar, Long id) {
        Alumno alumnoExistente = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con id " + id));

        alumnoExistente.setNombre(alumnoParaActualizar.getNombre());
        alumnoExistente.setApellido(alumnoParaActualizar.getApellido());
        alumnoExistente.setEmail(alumnoParaActualizar.getEmail());
        alumnoExistente.setDni(alumnoParaActualizar.getDni());
        alumnoExistente.setFechaNacimiento(alumnoParaActualizar.getFechaNacimiento());
        alumnoExistente.setAtributoBooleano(alumnoParaActualizar.getAtributoBooleano());
        return alumnoRepository.save(alumnoExistente);
    }

    @Override
    public List<Alumno> findByAtributoBooleanoTrue() {
        return alumnoRepository.findByAtributoBooleanoTrue();
    }

    @Override
    public List<Alumno> findByAtributoBooleanoFalse() {
        return alumnoRepository.findByAtributoBooleanoFalse();
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
    public List<Alumno> findByApellido(String apellido) {
        return alumnoRepository.findByApellido(apellido);
    }

    @Override
    public long countByEmail(String email) {
        return alumnoRepository.countByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return alumnoRepository.existsById(id);
    }
}