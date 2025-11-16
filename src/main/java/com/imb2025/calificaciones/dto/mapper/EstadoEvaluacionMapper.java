package com.imb2025.calificaciones.dto.mapper;

import com.imb2025.calificaciones.dto.request.EstadoEvaluacionRequestDto;
import com.imb2025.calificaciones.dto.response.EstadoEvaluacionResponseDto;
import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import org.springframework.stereotype.Component;

@Component
public class EstadoEvaluacionMapper {

    public EstadoEvaluacion fromDto(EstadoEvaluacionRequestDto dto) {
        EstadoEvaluacion estado = new EstadoEvaluacion();
        estado.setNombre(dto.getNombre());
        estado.setDescripcion(dto.getDescripcion());
        return estado;
    }

    public EstadoEvaluacionResponseDto toResponse(EstadoEvaluacion entity) {
        if (entity == null) {
            return null;
        }
        EstadoEvaluacionResponseDto dto = new EstadoEvaluacionResponseDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setVersion(entity.getVersion().longValue());
        return dto;
    }
}
