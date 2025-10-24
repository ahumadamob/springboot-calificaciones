package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;
import com.imb2025.calificaciones.dto.request.DocenteRequestDto;
import com.imb2025.calificaciones.dto.response.DocenteResponseDto;
import com.imb2025.calificaciones.entity.Docente;

@Component

public class DocenteMapper {

    public Docente fromDto(DocenteRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Docente docente = new Docente();

        docente.setNombre(dto.getNombre());
        docente.setApellido(dto.getApellido());
        docente.setLegajo(dto.getLegajo());
        docente.setEmail(dto.getEmail());
        docente.setTitulo(dto.getTitulo());

        docente.setActivo(dto.isActivo());

        return docente;
    }

    public DocenteResponseDto toResponseDto(Docente docente) {
        if (docente == null) {
            return null;
        }

        DocenteResponseDto dto = new DocenteResponseDto();

        dto.setId(docente.getId());
        dto.setNombre(docente.getNombre());
        dto.setApellido(docente.getApellido());
        dto.setLegajo(docente.getLegajo());
        dto.setEmail(docente.getEmail());
        dto.setTitulo(docente.getTitulo());

        dto.setActivo(docente.isActivo());

        dto.setVersion(docente.getVersion());

        return dto;
    }
}
