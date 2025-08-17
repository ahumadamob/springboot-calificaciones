package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.DocenteRequestDto;
import com.imb2025.calificaciones.entity.Docente;
import java.util.List;

public interface IDocenteService {

    public List<Docente> findAll();

    public Docente create(Docente docente);

    public Docente update(Docente docente, Long id);

    public Docente findById(Long id);

    public void deleteById(Long id);

    public Docente fromDto(DocenteRequestDto dto) throws Exception;
}
