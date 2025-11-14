package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.request.RegistroClaseRequestDto;
import com.imb2025.calificaciones.entity.RegistroClase;

import java.time.LocalDate;
import java.util.List;

public interface IRegistroClaseService {

    List<RegistroClase> findAll();

    RegistroClase create(RegistroClase registroClase);

    RegistroClase update(RegistroClase registroClase, Long id) throws Exception;

    RegistroClase findById(Long id);

    void deleteById(Long id) throws Exception;

    
    RegistroClase fromDto(RegistroClaseRequestDto dto) throws Exception;

    
    RegistroClase createFromDto(RegistroClaseRequestDto dto) throws Exception;

    RegistroClase updateFromDto(Long id, RegistroClaseRequestDto dto) throws Exception;

    List<RegistroClase> findByTema(String tema);

    Long countByFecha(LocalDate fecha);
}

