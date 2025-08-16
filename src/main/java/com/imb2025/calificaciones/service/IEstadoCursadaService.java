package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.EstadoCursadaRequestDto;
import com.imb2025.calificaciones.entity.EstadoCursada;
import java.util.List;

public interface IEstadoCursadaService {

    public List<EstadoCursada> findAll();

    public EstadoCursada findById(Long id);

    public EstadoCursada create(EstadoCursadaRequestDto dto);

    public EstadoCursada update(Long id, EstadoCursadaRequestDto dto) throws Exception;

    public void deleteById(Long id);

    public EstadoCursada fromDto(EstadoCursadaRequestDto dto);
}
