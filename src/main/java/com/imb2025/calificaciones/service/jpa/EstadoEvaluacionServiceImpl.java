package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.EstadoEvaluacionRequestDto;
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
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("EstadoEvaluacion no encontrada con id " + id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public EstadoEvaluacion create(EstadoEvaluacion estadoEvaluacion) {
        return repository.save(estadoEvaluacion);
    }

    @Override
    public EstadoEvaluacion update(EstadoEvaluacion estadoEvaluacion, Long id) throws ResourceNotFoundException {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("EstadoEvaluacion con id " + id + " no existe");
        }
        estadoEvaluacion.setId(id);
        return repository.save(estadoEvaluacion);
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("EstadoEvaluacion con id " + id + " no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public EstadoEvaluacion fromDto(EstadoEvaluacionRequestDto dto) throws Exception {
        EstadoEvaluacion estado = new EstadoEvaluacion();
        estado.setNombre(dto.getNombre());
        estado.setDescripcion(dto.getDescripcion());
        return estado;
    }
}
