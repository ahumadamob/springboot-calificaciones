package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.EstadoCursadaRequestDto;
import com.imb2025.calificaciones.entity.EstadoCursada;
import com.imb2025.calificaciones.repository.EstadoCursadaRepository;
import com.imb2025.calificaciones.service.IEstadoCursadaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoCursadaServiceImpl implements IEstadoCursadaService {

    @Autowired
    private EstadoCursadaRepository repository;

    @Override
    public List<EstadoCursada> findAll() {
        return repository.findAll();
    }

    @Override
    public EstadoCursada findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EstadoCursada create(EstadoCursada estadoCursada) {
        return repository.save(estadoCursada);
    }

    @Override
    public EstadoCursada update(EstadoCursada estadoCursada, Long id) throws Exception{
        if(repository.existsById(id)) {
            estadoCursada.setId(id);
            return repository.save(estadoCursada);
        } else {
            throw new Exception("No se encontró estadoCursada con id "+id);
        }

    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public EstadoCursada fromDto(EstadoCursadaRequestDto estadoCursadaRequestDto) throws Exception {
        EstadoCursada estadoCursada = new EstadoCursada();
        estadoCursada.setNombre(estadoCursadaRequestDto.getNombre());
        estadoCursada.setDescripcion(estadoCursadaRequestDto.getDescripcion());
        return estadoCursada;
    }

}
