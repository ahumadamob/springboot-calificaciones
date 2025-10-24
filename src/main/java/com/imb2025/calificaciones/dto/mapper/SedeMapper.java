package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.SedeRequestDto;
import com.imb2025.calificaciones.dto.response.SedeResponseDto;
import com.imb2025.calificaciones.entity.Sede;

@Component
public class SedeMapper {

    public Sede fromDto(SedeRequestDto dto) {
        if (dto == null) return null;
        Sede s = new Sede();
        s.setNombre(dto.getNombre());
        s.setDireccion(dto.getDireccion());
        s.setActiva(dto.getActiva());
        return s;
    }

    public SedeResponseDto toResponse(Sede sede) {
        if (sede == null) return null;
        Long localidadId = null;
        SedeResponseDto r = new SedeResponseDto();
        r.setId(sede.getId());
        r.setNombre(sede.getNombre());
        r.setDireccion(sede.getDireccion());
        r.setLocalidadId(localidadId);
        r.setVersion(null);
        r.setActiva(sede.getActiva());
        return r;
    }
}
