package com.imb2025.calificaciones.condicionfinal.service;

import com.imb2025.calificaciones.condicionfinal.dto.CondicionFinalRequestDTO;
import com.imb2025.calificaciones.condicionfinal.entity.CondicionFinal;
import com.imb2025.calificaciones.condicionfinal.entity.Materia;
import com.imb2025.calificaciones.condicionfinal.exception.EntidadNoEncontradaException;
import com.imb2025.calificaciones.condicionfinal.repository.CondicionFinalRepository;
import com.imb2025.calificaciones.condicionfinal.repository.MateriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicionFinalServiceImpl implements CondicionFinalService {

    private final CondicionFinalRepository condicionFinalRepository;
    private final MateriaRepository materiaRepository;

    public CondicionFinalServiceImpl(CondicionFinalRepository condicionFinalRepository, MateriaRepository materiaRepository) {
        this.condicionFinalRepository = condicionFinalRepository;
        this.materiaRepository = materiaRepository;
    }

    @Override
    public List<CondicionFinal> getAll() {
        return condicionFinalRepository.findAll();
    }

    @Override
    public CondicionFinal getById(Long id) {
        return condicionFinalRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Condición Final con ID " + id + " no encontrada."));
    }

    @Override
    public CondicionFinal create(CondicionFinalRequestDTO dto) {
        Materia materia = materiaRepository.findById(dto.getMateriaId())
                .orElseThrow(() -> new EntidadNoEncontradaException("La materia con ID " + dto.getMateriaId() + " no existe."));

        CondicionFinal cf = new CondicionFinal();
        cf.setNombre(dto.getNombre());
        cf.setApellido(dto.getApellido());
        cf.setDni(dto.getDni());
        cf.setMateria(materia);

        return condicionFinalRepository.save(cf);
    }

    @Override
    public CondicionFinal update(Long id, CondicionFinalRequestDTO dto) {
        CondicionFinal cf = condicionFinalRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Condición Final con ID " + id + " no encontrada."));

        Materia materia = materiaRepository.findById(dto.getMateriaId())
                .orElseThrow(() -> new EntidadNoEncontradaException("La materia con ID " + dto.getMateriaId() + " no existe."));

        cf.setNombre(dto.getNombre());
        cf.setApellido(dto.getApellido());
        cf.setDni(dto.getDni());
        cf.setMateria(materia);

        return condicionFinalRepository.save(cf);
    }

    @Override
    public void delete(Long id) {
        if (!condicionFinalRepository.existsById(id)) {
            throw new EntidadNoEncontradaException("Condición Final con ID " + id + " no encontrada.");
        }
        condicionFinalRepository.deleteById(id);
    }
}
