package com.imb2025.calificaciones.condicionfinal.service;

import com.imb2025.calificaciones.condicionfinal.entity.CondicionFinal;
import com.imb2025.calificaciones.condicionfinal.repository.CondicionFinalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondicionFinalServiceImpl implements CondicionFinalService {

    @Autowired
    private CondicionFinalRepository repository;

    public List<CondicionFinal> getAll() {
        return repository.findAll();
    }

    public CondicionFinal save(CondicionFinal cf) {
        return repository.save(cf);
    }

    public CondicionFinal getById(Long id) {
        Optional<CondicionFinal> result = repository.findById(id);
        return result.orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
