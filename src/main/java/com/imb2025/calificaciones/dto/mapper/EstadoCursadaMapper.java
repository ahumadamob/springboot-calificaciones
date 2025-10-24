package com.imb2025.calificaciones.dto.mapper;

import com.imb2025.calificaciones.dto.request.EstadoCursadaRequestDto;
import com.imb2025.calificaciones.dto.response.EstadoCursadaResponseDto;
import com.imb2025.calificaciones.entity.EstadoCursada;

public class EstadoCursadaMapper {

    public EstadoCursada fromDto(EstadoCursadaRequestDto estadoCursadaRequestDto) throws Exception {
        EstadoCursada estadoCursada = new EstadoCursada();
        estadoCursada.setNombre(estadoCursadaRequestDto.getNombre());
        estadoCursada.setDescripcion(estadoCursadaRequestDto.getDescripcion());
        estadoCursada.setIdentificadorLegible(estadoCursadaRequestDto.getIdentificadorLegible());
        return estadoCursada;
    }
    
    public EstadoCursadaResponseDto toResponseDto(EstadoCursada estadoCursada) {
    	EstadoCursadaResponseDto dto = new EstadoCursadaResponseDto();
    	dto.setId(estadoCursada.getId());
    	dto.setNombre(estadoCursada.getNombre());
    	dto.setDescipcion(estadoCursada.getDescripcion());
    	dto.setIdentificadorLegible(estadoCursada.getIdentificadorLegible());
    	
    	return dto;
    }
}
