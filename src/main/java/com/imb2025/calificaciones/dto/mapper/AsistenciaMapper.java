package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.AsistenciaRequestDto;
import com.imb2025.calificaciones.dto.response.AsistenciaResponseDto;
import com.imb2025.calificaciones.entity.Asistencia;

@Component
public class AsistenciaMapper {

    public Asistencia fromDto(AsistenciaRequestDto dto) {
        Asistencia asistencia = new Asistencia();
        asistencia.setPresente(dto.getPresente());
        asistencia.setObservaciones(dto.getObservaciones());
        return asistencia;
    }

    public AsistenciaResponseDto toResponse(Asistencia asistencia) {
        AsistenciaResponseDto dto = new AsistenciaResponseDto();
        dto.setId(asistencia.getId());
        dto.setAlumnoNombre(asistencia.getAlumno() != null ? asistencia.getAlumno().getNombre() : null);
        dto.setRegistroClaseTema(asistencia.getRegistroClase() != null ? asistencia.getRegistroClase().getTema() : null);
        dto.setPresente(asistencia.getPresente());
        dto.setObservaciones(asistencia.getObservaciones());
        dto.setVersion(asistencia.getVersion());
        return dto;
    }
}
