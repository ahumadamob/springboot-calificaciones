package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.request.EstadoCursadaRequestDto;
import com.imb2025.calificaciones.entity.EstadoCursada;
import java.util.List;

public interface IEstadoCursadaService {

    public List<EstadoCursada> findAll();

    public EstadoCursada create(EstadoCursada estadoCursada);

    public EstadoCursada update(EstadoCursada estadoCursada, Long id) throws Exception;

    public EstadoCursada findById(Long id);

    public void deleteById(Long id) throws Exception;
    
    List<EstadoCursada> findByNombreIgnoreCase(String nombre);
    long countByDescripcionIgnoreCase(String descripcion);

}
