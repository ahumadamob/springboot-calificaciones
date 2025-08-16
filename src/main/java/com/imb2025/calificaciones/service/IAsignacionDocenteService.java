package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.AsignacionDocenteRequestDto;
import com.imb2025.calificaciones.entity.AsignacionDocente;
import java.util.List;

public interface IAsignacionDocenteService {

    public List<AsignacionDocente> findAll();

    public AsignacionDocente findById(Long id);

    public AsignacionDocente create(AsignacionDocenteRequestDto dto);

    public AsignacionDocente update(Long id, AsignacionDocenteRequestDto dto) throws Exception;

    public void deleteById(Long id) throws Exception;

    public AsignacionDocente fromDto(AsignacionDocenteRequestDto dto);
}

