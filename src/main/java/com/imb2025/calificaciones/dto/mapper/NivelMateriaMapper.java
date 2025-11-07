package com.imb2025.calificaciones.dto.mapper;

import com.imb2025.calificaciones.dto.request.NivelMateriaRequestDto;
import com.imb2025.calificaciones.dto.response.NivelMateriaResponseDto;
import com.imb2025.calificaciones.entity.NivelMateria;

public class NivelMateriaMapper {

    public static NivelMateria fromDto(NivelMateriaRequestDto dto) throws Exception {
        if (dto == null) {
            throw new Exception("El dto de nivel materia no puede ser nulo");
        }

        NivelMateria nivelMateria = new NivelMateria();
        nivelMateria.setNombre(dto.getNombre());
        nivelMateria.setDescripcion(dto.getDescripcion());
        nivelMateria.setActivo(dto.getActivo());
        nivelMateria.setIdentificadorLegible(dto.getIdentificadorLegible());
        return nivelMateria;
    }

    public static NivelMateriaResponseDto toResponseDto(NivelMateria entidad) {
        if (entidad == null) {
            return null;
        }

        NivelMateriaResponseDto dto = new NivelMateriaResponseDto();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setActivo(entidad.getActivo());
        dto.setVersion(entidad.getVersion());
        dto.setIdentificadorLegible(entidad.getIdentificadorLegible());
        return dto;
    }
}