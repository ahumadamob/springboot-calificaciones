package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.AsignacionDocenteRequestDto;
import com.imb2025.calificaciones.entity.AsignacionDocente;
import java.util.List;

public interface IAsignacionDocenteService {

    public List<AsignacionDocente> findAll();

    public AsignacionDocente create(AsignacionDocente asignacionDocente);

    public AsignacionDocente update(AsignacionDocente asignacionDocente, Long id) throws Exception;

    public AsignacionDocente findById(Long id);

    public void deleteById(Long id);

    public AsignacionDocente fromDto(AsignacionDocenteRequestDto dto) throws Exception;
}
