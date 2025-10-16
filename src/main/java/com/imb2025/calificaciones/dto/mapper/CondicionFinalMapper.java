package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.CondicionFinalRequestDto;
import com.imb2025.calificaciones.dto.response.CondicionFinalResponseDto;
import com.imb2025.calificaciones.entity.CondicionFinal;

@Component
public class CondicionFinalMapper {

    public CondicionFinal toEntity(CondicionFinalRequestDto dto) {
        if (dto == null) {
            return null;
        }
        CondicionFinal entity = new CondicionFinal();
        entity.setNombre(dto.getNombre());
        return entity;
    }

    public CondicionFinalResponseDto toResponseDto(CondicionFinal entity) {
        if (entity == null) {
            return null;
        }
        CondicionFinalResponseDto dto = new CondicionFinalResponseDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setVersion(entity.getVersion());
        return dto;
    }
}
