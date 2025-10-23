package com.imb2025.calificaciones.dto.mapper;

import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.ObservacionAlumnoRequestDto;
import com.imb2025.calificaciones.dto.response.ObservacionAlumnoResponseDto;
import com.imb2025.calificaciones.entity.ObservacionAlumno;

@Component
public class ObservacionAlumnoMapper {
	
	 public ObservacionAlumno fromDto(ObservacionAlumnoRequestDto dto) {
	        ObservacionAlumno observacion = new ObservacionAlumno();
	        observacion.setFecha(dto.getFecha());
	        observacion.setTexto(dto.getTexto());
	        observacion.setRevisada(dto.getRevisada());
	        return observacion;
	    }
	
	public ObservacionAlumnoResponseDto toResponseDto (ObservacionAlumno observacionAlumno) {
		ObservacionAlumnoResponseDto response = new ObservacionAlumnoResponseDto();
		response.setId(observacionAlumno.getId());
		response.setAlumno(observacionAlumno.getAlumno());
		response.setDocente(observacionAlumno.getDocente());
		response.setTexto(observacionAlumno.getTexto());
		response.setFecha(observacionAlumno.getFecha());
		response.setVersion(observacionAlumno.getVersion());
		response.setRevisada(observacionAlumno.getRevisada());
		
		return response;

    }
}
