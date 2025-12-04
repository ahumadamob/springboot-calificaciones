package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.PeriodoLectivoRequestDto;
import com.imb2025.calificaciones.dto.response.PeriodoLectivoResponseDto;
import com.imb2025.calificaciones.entity.PeriodoLectivo;

@Component
public class PeriodoLectivoMapper {
	
	public PeriodoLectivo fromDto(PeriodoLectivoRequestDto requestDTO) {
        PeriodoLectivo periodoLectivo = new PeriodoLectivo();

        periodoLectivo.setNombre(requestDTO.getNombre());
        periodoLectivo.setFechaInicio(requestDTO.getFechaInicio());
        periodoLectivo.setFechaFin(requestDTO.getFechaFin());
        periodoLectivo.setDescripcionCorta(requestDTO.getDescripcionCorta());

        return periodoLectivo;
    }
	
	public PeriodoLectivoResponseDto toResponse(PeriodoLectivo periodo) {
		PeriodoLectivoResponseDto dto = new PeriodoLectivoResponseDto();
		
		dto.setId(periodo.getId());
		dto.setNombre(periodo.getNombre());
		dto.setFechaInicio(periodo.getFechaInicio());
		dto.setFechaFin(periodo.getFechaFin());
		dto.setVersion(periodo.getVersion());
		dto.setDescripcionCorta(periodo.getDescripcionCorta());
		
		return dto;
	}
}
