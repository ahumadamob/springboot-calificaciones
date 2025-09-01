package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.DocenteRequestDto;
import com.imb2025.calificaciones.entity.Docente;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IDocenteService {

    public List<Docente> findAll();

    public Docente create(Docente docente);

    public Docente update(Docente docente, Long id) throws Exception;

    public Docente findById(Long id);

    public void deleteById(Long id) throws Exception;

    public Docente fromDto(DocenteRequestDto dto) throws Exception;

    public ResponseEntity<Docente> existsById(Long id);

}
