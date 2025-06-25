package com.imb2025.calificaciones.condicionfinal.service;

import com.imb2025.calificaciones.condicionfinal.dto.CondicionFinalRequestDTO;
import com.imb2025.calificaciones.condicionfinal.entity.CondicionFinal;
import com.imb2025.calificaciones.condicionfinal.entity.Materia;
import com.imb2025.calificaciones.condicionfinal.exception.EntidadNoEncontradaException;
import com.imb2025.calificaciones.condicionfinal.repository.CondicionFinalRepository;
import com.imb2025.calificaciones.condicionfinal.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicionFinalServiceImpl implements CondicionFinalService {

    @Autowired
    private CondicionFinalRepository cfRepo;

    @Autowired
    private MateriaRepository materiaRepo;

    @Override
    public List<CondicionFinal> getAll() {
        return cfRepo.findAll();
    }

    @Override
    public CondicionFinal getById(Long id) {
        return cfRepo.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Condición final no encontrada con ID: " + id));
    }

    @Override
    public CondicionFinal create(CondicionFinalRequestDTO dto) {
        Materia materia = materiaRepo.findById(dto.getMateriaId())
                .orElseThrow(() -> new EntidadNoEncontradaException("Materia no encontrada con ID: " + dto.getMateriaId()));

        CondicionFinal cf = new CondicionFinal();
        cf.setNombre(dto.getNombre());
        cf.setApellido(dto.getApellido());
        cf.setDni(dto.getDni());
        cf.setMateria(materia);

        return cfRepo.save(cf);
    }

    @Override
    public CondicionFinal update(Long id, CondicionFinalRequestDTO dto) {
        if (!cfRepo.existsById(id)) {
            throw new EntidadNoEncontradaException("Condición final no encontrada con ID: " + id);
        }

        Materia materia = materiaRepo.findById(dto.getMateriaId())
                .orElseThrow(() -> new EntidadNoEncontradaException("Materia no encontrada con ID: " + dto.getMateriaId()));

        CondicionFinal cf = new CondicionFinal();
        cf.setId(id);
        cf.setNombre(dto.getNombre());
        cf.setApellido(dto.getApellido());
        cf.setDni(dto.getDni());
        cf.setMateria(materia);

        return cfRepo.save(cf);
    }

    @Override
    public void delete(Long id) {
        if (!cfRepo.existsById(id)) {
            throw new EntidadNoEncontradaException("Condición final no encontrada con ID: " + id);
        }
        cfRepo.deleteById(id);
    }
}
