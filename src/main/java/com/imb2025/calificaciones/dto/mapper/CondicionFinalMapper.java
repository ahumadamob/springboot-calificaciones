package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.CondicionFinalRequestDto;
import com.imb2025.calificaciones.dto.response.CondicionFinalResponseDto;
import com.imb2025.calificaciones.entity.CondicionFinal;

@Component
public class CondicionFinalMapper {

    public CondicionFinal fromDto(CondicionFinalRequestDto dto) {
        CondicionFinal condicion = new CondicionFinal();
        condicion.setNombre(dto.getNombre());
        return condicion;
    }

    public CondicionFinalResponseDto toResponse(CondicionFinal entidad) {
        CondicionFinalResponseDto dto = new CondicionFinalResponseDto();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setVersion(entidad.getVersion());
        return dto;
    }
}
