package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.EstadoCursadaRequestDto;
import com.imb2025.calificaciones.entity.EstadoCursada;
import java.util.List;

public interface IEstadoCursadaService {

    public List<EstadoCursada> findAll();

    public EstadoCursada create(EstadoCursada estadoCursada);

    public EstadoCursada update(EstadoCursada estadoCursada, Long id) throws Exception;

    public EstadoCursada findById(Long id);

    public void deleteById(Long id);

    public EstadoCursada fromDto(EstadoCursadaRequestDto dto) throws Exception;
}
