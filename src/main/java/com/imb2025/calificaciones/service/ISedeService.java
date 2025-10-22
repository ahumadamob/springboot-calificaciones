package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.SedeRequestDto;
import com.imb2025.calificaciones.entity.Sede;
import java.util.List;

public interface ISedeService {

    List<Sede> findAll();

    Sede create(Sede sede) throws Exception;

    Sede update(Sede sede, Long id) throws Exception;

    Sede findById(Long id);

    void deleteById(Long id) throws Exception;

    Sede fromDto(SedeRequestDto dto) throws Exception;

    Sede createFromDto(SedeRequestDto dto) throws Exception;

    boolean existsById(Long id);

    List<Sede> findByNombreIgnoreCase(String nombre);

    long countByDireccionIgnoreCase(String direccion);
}
