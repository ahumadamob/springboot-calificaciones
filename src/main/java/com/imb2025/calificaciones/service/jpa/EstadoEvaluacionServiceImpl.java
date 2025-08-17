package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imb2025.calificaciones.dto.EstadoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;
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
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public EstadoEvaluacion create(EstadoEvaluacionRequestDto dto) {
        EstadoEvaluacion estado = fromDto(dto);
        return repository.save(estado);
    }

    @Override
    @Transactional
    public EstadoEvaluacion update(Long id, EstadoEvaluacionRequestDto dto) {
        EstadoEvaluacion existente = repository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setNombre(dto.getNombre());
        existente.setDescripcion(dto.getDescripcion());
        return repository.save(existente);
    }

    @Override
    public void deleteById(Long id) {
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
