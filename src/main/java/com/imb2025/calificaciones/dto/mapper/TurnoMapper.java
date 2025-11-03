package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.TurnoRequestDto;
import com.imb2025.calificaciones.dto.response.TurnoResponseDto;
import com.imb2025.calificaciones.entity.Turno;

@Component
public class TurnoMapper {
	
	
	public Turno fromDto(TurnoRequestDto turnoRequestDto) throws Exception {
        Turno turno = new Turno();
        turno.setNombre(turnoRequestDto.getNombre());
        turno.setHoraInicio(turnoRequestDto.getHoraInicio());
        turno.setHoraFin(turnoRequestDto.getHoraFin());
        return turno;
    }
	
	public TurnoResponseDto toResponseDto(Turno turno) throws Exception {
       TurnoResponseDto dto = new TurnoResponseDto();
		
       dto.setId(turno.getId());
       dto.setNombre(turno.getNombre());
       dto.setHoraInicio(turno.getHoraInicio());
       dto.setHoraFin(turno.getHoraFin());
      dto.setVersion(turno.getVersion());
        return dto;
    }

}
