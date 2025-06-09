package com.imb2025.calificaciones.condicionfinal.service.jpa;

import com.imb2025.calificaciones.condicionfinal.dto.CondicionFinalRequestDTO;
import com.imb2025.calificaciones.condicionfinal.entity.CondicionFinal;
import com.imb2025.calificaciones.condicionfinal.exception.EntidadNoEncontradaException;
import com.imb2025.calificaciones.condicionfinal.repository.CondicionFinalRepository;
import com.imb2025.calificaciones.condicionfinal.service.CondicionFinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondicionFinalServiceImpl implements CondicionFinalService {

    @Autowired
    private CondicionFinalRepository repository;

    @Override
    public List<CondicionFinal> getAll() {
        return repository.findAll();
    }

    @Override
    public CondicionFinal getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Condición final no encontrada con ID: " + id));
    }

    @Override
    public CondicionFinal create(CondicionFinalRequestDTO dto) {
        CondicionFinal nueva = new CondicionFinal();
        nueva.setNombre(dto.getNombre());
        return repository.save(nueva);
    }

    @Override
    public CondicionFinal update(Long id, CondicionFinalRequestDTO dto) {
        Optional<CondicionFinal> opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new EntidadNoEncontradaException("Condición final no encontrada con ID: " + id);
        }

        CondicionFinal existente = opt.get();
        existente.setNombre(dto.getNombre());
        return repository.save(existente);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntidadNoEncontradaException("Condición final no encontrada con ID: " + id);
        }
        repository.deleteById(id);
    }
}
