package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.service.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServicesImpl implements IAlumnoServices {

    @Autowired
    private AlumnoRepository alumnoRepository;



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
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);

    }
}
