package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.SedeRequestDto;
import com.imb2025.calificaciones.entity.Sede;
import java.util.List;

public interface ISedeService {

    public List<Sede> findAll();

    // ahora create puede lanzar Exception para reportar validaciones/errores de existencia de relaciones
    public Sede create(Sede sede) throws Exception;

    public Sede update(Sede sede, Long id) throws Exception;

    public Sede findById(Long id);

    public void deleteById(Long id) throws Exception;


    public Sede fromDto(SedeRequestDto dto) throws Exception;

    // nuevo: crear directamente desde el DTO (útil para controlador POST)
    public Sede createFromDto(SedeRequestDto dto) throws Exception;
}
