package com.imb2025.calificaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.repository.InscripcionMateriaRepository;

@Service
public class InscripcionMateriaServiceImp implements InscripcionMateriaService{

    @Autowired
    private InscripcionMateriaRepository repository;

    public List<InscripcionMateria> findAll() {
        return repository.findAll();
    }

  
    public InscripcionMateria findById(Long id) {
        return repository.findById(id).orElse(null);
    }
   
    public InscripcionMateria save(InscripcionMateria inscripcionMateria) {
        return repository.save(inscripcionMateria);
    }

   
    public InscripcionMateria update(Long id, InscripcionMateria inscripcionMateria) {
        inscripcionMateria.setId(id);
    return repository.save(inscripcionMateria);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
