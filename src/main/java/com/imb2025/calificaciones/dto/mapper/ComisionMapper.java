package com.imb2025.calificaciones.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.ComisionRequestDto;
import com.imb2025.calificaciones.dto.response.ComisionResponseDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.entity.Sede;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.TurnoRepository;
import com.imb2025.calificaciones.repository.SedeRepository;

@Component
public class ComisionMapper {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private SedeRepository sedeRepository;

    // Convierte DTO de request a entidad, verificando existencia de relaciones
    public Comision fromDto(ComisionRequestDto dto) throws Exception {
        if (dto == null) {
            throw new IllegalArgumentException("DTO no puede ser nulo");
        }
        Comision c = new Comision();
        c.setNombre(dto.getNombre());

        if (dto.getTurnoId() != null) {
            Turno t = turnoRepository.findById(dto.getTurnoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Turno con id " + dto.getTurnoId() + " no encontrado"));
            c.setTurno(t);
        }

        if (dto.getSedeId() != null) {
            Sede s = sedeRepository.findById(dto.getSedeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Sede con id " + dto.getSedeId() + " no encontrada"));
            c.setSede(s);
        }
        
        if (dto.getDestacado() != null) {
        	c.setDestacado(Boolean.TRUE.equals(dto.getDestacado()));
        }

        return c;
    }

    // Convierte entidad a DTO de respuesta
    public ComisionResponseDto toResponseDto(Comision c) {
        if (c == null) return null;
        Long turnoId = c.getTurno() != null ? c.getTurno().getId() : null;
        Long sedeId = c.getSede() != null ? c.getSede().getId() : null;
        Long version = c.getVersion(); // puede ser null si no existe
        Boolean destacado = c.getDestacado();
        return new ComisionResponseDto(c.getId(), c.getNombre(), turnoId, sedeId, version,destacado);
        
    }
}
