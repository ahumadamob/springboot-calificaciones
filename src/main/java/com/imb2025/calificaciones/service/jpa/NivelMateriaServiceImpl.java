package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.NivelMateria;
import com.imb2025.calificaciones.repository.NivelMateriaRepository;
import com.imb2025.calificaciones.service.INivelMateriaService;

@Service
public class NivelMateriaServiceImpl implements INivelMateriaService {

    @Autowired
    private NivelMateriaRepository repo;

    @Override
    public List<NivelMateria> findAll() {
            return repo.findAll();

    }

    @Override
    public NivelMateria findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public NivelMateria save(NivelMateria nivelMateria) {
         return repo.save(nivelMateria);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }

    }

