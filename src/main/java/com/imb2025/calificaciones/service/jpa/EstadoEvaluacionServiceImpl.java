package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import com.imb2025.calificaciones.repository.EstadoEvaluacionRepository;
import com.imb2025.calificaciones.service.IEstadoEvaluacionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoEvaluacionServiceImpl implements IEstadoEvaluacionServices {

    @Autowired
    private EstadoEvaluacionRepository repository;

    @Override
    public List<EstadoEvaluacion> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public EstadoEvaluacion save(EstadoEvaluacion estadoEvaluacion) {
        EstadoEvaluacion estado = new EstadoEvaluacion();
        estado.setNombre(estadoEvaluacion.getNombre());
        estado.setDescripcion(estadoEvaluacion.getDescripcion());
        return repository.save(estado);
    }

    @Override
    @Transactional
    public EstadoEvaluacion update(Long id, EstadoEvaluacion estadoEvaluacion) {
        EstadoEvaluacion existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(estadoEvaluacion.getNombre());
            existente.setDescripcion(estadoEvaluacion.getDescripcion());
            return repository.save(existente);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EstadoEvaluacion findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
