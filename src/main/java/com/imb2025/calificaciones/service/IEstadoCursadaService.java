package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.EstadoCursadaRequestDto;
import com.imb2025.calificaciones.entity.EstadoCursada;

public interface IEstadoCursadaService {

    EstadoCursada findById(Long id);

    List<EstadoCursada> findAll();

    public EstadoCursada create(EstadoCursada estadoCursada);
	public EstadoCursada update(EstadoCursada estadoCursada, Long id) throws Exception;
    public void deleteById(Long id);
    public  EstadoCursada mapFromDto(EstadoCursadaRequestDto estadoCursadaRequestDTO);


}
