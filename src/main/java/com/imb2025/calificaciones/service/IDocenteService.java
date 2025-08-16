package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.DocenteRequestDto;
import com.imb2025.calificaciones.entity.Docente;
import java.util.List;

public interface IDocenteService {

    public List<Docente> findAll();

    public Docente findById(Long id);

    public Docente create(DocenteRequestDto dto);

    public Docente update(Long id, DocenteRequestDto dto) throws Exception;

    public void deleteById(Long id);

    public Docente fromDto(DocenteRequestDto dto);
}
