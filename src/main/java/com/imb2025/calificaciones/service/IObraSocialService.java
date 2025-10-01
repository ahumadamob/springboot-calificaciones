package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.ObraSocialRequestDto;
import com.imb2025.calificaciones.entity.ObraSocial;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;

public interface IObraSocialService {

    List<ObraSocial> findAll();

    ObraSocial create(ObraSocial obraSocial);

    ObraSocial update(ObraSocial obraSocial, Long id) throws ResourceNotFoundException, Exception;

    ObraSocial findById(Long id) throws ResourceNotFoundException;

    void deleteById(Long id) throws ResourceNotFoundException;

    ObraSocial fromDto(ObraSocialRequestDto dto);
}
