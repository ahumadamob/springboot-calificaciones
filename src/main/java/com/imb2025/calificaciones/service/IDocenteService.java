package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.dto.request.DocenteRequestDto;
import com.imb2025.calificaciones.dto.response.DocenteResponseDto;
import com.imb2025.calificaciones.entity.Docente;
import java.util.List;

public interface IDocenteService {

    public List<Docente> findAll();

    public Docente create(Docente docente);

    public Docente update(Docente docente, Long id) throws Exception;

    public Docente findById(Long id);

    public void deleteById(Long id) throws Exception;

    public Docente fromDto(DocenteRequestDto dto) throws Exception;

    public boolean existsById(Long id);

    List<Docente> findByApellido(String apellido);

    Long countByTitulo(String titulo);

    DocenteResponseDto create(DocenteRequestDto docenteDTO);

    DocenteResponseDto update(Long id, DocenteRequestDto docenteDTO) throws Exception;

}
