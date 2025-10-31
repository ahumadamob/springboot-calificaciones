package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.InscripcionMateria;

import com.imb2025.calificaciones.exception.ResourceNotFoundException;

import com.imb2025.calificaciones.repository.InscripcionMateriaRepository;
import com.imb2025.calificaciones.service.IInscripcionMateriaService;

@Service
public class InscripcionMateriaServiceImpl implements IInscripcionMateriaService {

    @Autowired
    private InscripcionMateriaRepository repository;

    

    @Override
    public List<InscripcionMateria> findAll() {
        return repository.findAll();
    }
    
    @Override
    public InscripcionMateria findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Entidad no encontrada con id " + id));
    }

    @Override
    public List<InscripcionMateria> findByAlumno_Id(Long idAlumno) {
        return repository.findByAlumno_Id(idAlumno);
    }

    @Override
    public long countByAlumno_Id(Long idAlumno) {
        return repository.countByAlumno_Id(idAlumno);
    }
    
    @Override
    public InscripcionMateria create(InscripcionMateria inscripcionMateria) {
        return repository.save(inscripcionMateria);
    }

    @Override
    public InscripcionMateria update(InscripcionMateria inscripcionMateria, Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
        }
        inscripcionMateria.setId(id);
        return repository.save(inscripcionMateria);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
        }
        repository.deleteById(id);
    }

    

    
}
