package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.TipoEvaluacionRequestDto;
import com.imb2025.calificaciones.dto.response.TipoEvaluacionResponseDto;
import com.imb2025.calificaciones.entity.TipoEvaluacion;

@Component
	public class TipoEvaluacionMapper {


	    public TipoEvaluacion fromRequest(TipoEvaluacionRequestDto dto) {
	        var e = new TipoEvaluacion();
	        e.setNombre(dto.getNombre());
	        e.setDescripcion(dto.getDescripcion());
	        return e;
	    }

	    public TipoEvaluacionResponseDto toResponse(TipoEvaluacion e) {
	        if (e == null) return null;
	        var dto = new TipoEvaluacionResponseDto();
	        dto.setId(e.getId());
	        dto.setNombre(e.getNombre());
	        dto.setDescripcion(e.getDescripcion());
	        dto.setVersion(e.getVersion());
	        return dto;
	    }

	    public void copyToEntity(TipoEvaluacionRequestDto dto, TipoEvaluacion target) {
	        target.setNombre(dto.getNombre());
	        target.setDescripcion(dto.getDescripcion());
	    }
}
