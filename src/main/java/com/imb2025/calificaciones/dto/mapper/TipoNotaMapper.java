package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.TipoNotaRequestDto;
import com.imb2025.calificaciones.dto.response.TipoNotaResponseDto;
import com.imb2025.calificaciones.entity.TipoNota;

@Component
public class TipoNotaMapper {
	
	public TipoNota fromDto(TipoNotaRequestDto dto) {
	        if (dto == null) {
	            throw new IllegalArgumentException("El dto de tipo nota no puede ser nulo");
	        }
	        TipoNota tipoNota = new TipoNota();
	        tipoNota.setNombre(dto.getNombre());
	        tipoNota.setDescripcion(dto.getDescripcion());
	        return tipoNota;
	    }
	
	public TipoNotaResponseDto toResponse(TipoNota tipoNota) {
        if (tipoNota == null) {
            return null;
        }
        TipoNotaResponseDto dto = new TipoNotaResponseDto();
        dto.setId(tipoNota.getId());
        dto.setNombre(tipoNota.getNombre());
        dto.setVersion(tipoNota.getVersion());
        return dto;
    }
}
