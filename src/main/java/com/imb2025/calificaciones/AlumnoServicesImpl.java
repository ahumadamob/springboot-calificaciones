package com.imb2025.calificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServicesImpl implements AlumnoServices {

    @Autowired
    AlumnoRepository alumnoRepository;



    @Override
    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno save(Alumno nuevoAlumno) {
        return alumnoRepository.save(nuevoAlumno);
    }

    @Override
    public Alumno update(Long id, Alumno datosActualizados) {
        return alumnoRepository.save(datosActualizados);
    }

    @Override
    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public Optional<Alumno> findById(Long id) {
        return alumnoRepository.findById(id);
    }
}
