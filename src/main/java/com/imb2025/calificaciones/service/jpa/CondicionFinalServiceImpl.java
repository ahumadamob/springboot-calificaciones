package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.CondicionFinal;
import com.imb2025.calificaciones.repository.CondicionFinalRepository;
import com.imb2025.calificaciones.service.ICondicionFinalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondicionFinalServiceImpl implements ICondicionFinalService {

    @Autowired
    private CondicionFinalRepository repository;

    @Override
    public List<CondicionFinal> findAll() {
        return repository.findAll();
    }

    @Override
    public CondicionFinal create(CondicionFinal condicionFinal) {
        return repository.save(condicionFinal);
    }

    @Override
    public CondicionFinal update(CondicionFinal condicionFinal, Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("CondicionFinal no encontrada con id: " + id);
        }
        condicionFinal.setId(id);
        return repository.save(condicionFinal);
    }

    @Override
    public CondicionFinal findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public List<CondicionFinal> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public Long countByNombre(String nombre) {
        return repository.countByNombre(nombre);
    }
}
