package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.EstadoEvaluacionRepository;
import com.imb2025.calificaciones.service.IEstadoEvaluacionService;

@Service
public class EstadoEvaluacionServiceImpl implements IEstadoEvaluacionService {

    @Autowired
    private EstadoEvaluacionRepository repository;

    @Override
    public List<EstadoEvaluacion> findAll() {
        return repository.findAll();
    }

    @Override
    public EstadoEvaluacion findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("EstadoEvaluacion con id " + id + " no encontrado."));
    }

    @Override
    public EstadoEvaluacion create(EstadoEvaluacion estadoEvaluacion) {
        return repository.save(estadoEvaluacion);
    }

    @Override
    @Transactional
    public EstadoEvaluacion update(EstadoEvaluacion estadoEvaluacion, Long id) throws Exception {
        if (repository.existsById(id)) {
            estadoEvaluacion.setId(id);
            return repository.save(estadoEvaluacion);
        } else {
            throw new ResourceNotFoundException("EstadoEvaluacion con ID " + id + " no encontrado.");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar el id: " + id + " porque no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public List<EstadoEvaluacion> findByNombre(String nombre) {
        return repository.findByNombreIgnoreCase(nombre);
    }

    @Override
    public long countByDescripcion(String descripcion) {
        return repository.countByDescripcion(descripcion);
    }
}
