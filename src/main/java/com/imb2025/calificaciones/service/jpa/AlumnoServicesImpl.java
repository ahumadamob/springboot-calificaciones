package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.service.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServicesImpl implements IAlumnoServices {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Alumno update(Long id, Alumno datosActualizados) throws Exception {
        if (alumnoRepository.existsById(id)) {
            datosActualizados.setId(id);
            return alumnoRepository.save(datosActualizados);
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
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Override
    public Alumno create(Alumno nuevoAlumno) {
        return alumnoRepository.save(nuevoAlumno);
    }

    @Override
    public void deleteById(Long id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Estudiante no encontrado");
        }
    }
}
