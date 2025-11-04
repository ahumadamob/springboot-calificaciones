package com.imb2025.calificaciones.dto.mapper;

import com.imb2025.calificaciones.dto.request.CursadaRequestDto;
import com.imb2025.calificaciones.dto.response.CursadaResponseDto;
import com.imb2025.calificaciones.entity.Cursada;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.AnioLectivo;
import com.imb2025.calificaciones.entity.CondicionFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.CondicionFinalRepository;


@Component
public class CursadaMapper {

	    @Autowired
	    private AlumnoRepository alumnoRepository;

	    @Autowired
	    private MateriaRepository materiaRepository;

	   
	    @Autowired
	    private CondicionFinalRepository condicionFinalRepository;

	    public Cursada fromDto(CursadaRequestDto dto) throws Exception {
	        Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
	                .orElseThrow(() -> new Exception("Alumno no encontrado con id: " + dto.getAlumnoId()));
	        Materia materia = materiaRepository.findById(dto.getMateriaId())
	                .orElseThrow(() -> new Exception("Materia no encontrada con id: " + dto.getMateriaId()));
	        AnioLectivo anioLectivo = null;

	     
	        CondicionFinal condicionFinal = condicionFinalRepository.findById(dto.getCondicionFinalId())
	                .orElseThrow(() -> new Exception("Condición final no encontrada con id: " + dto.getCondicionFinalId()));

	        return new Cursada(alumno, materia, anioLectivo, condicionFinal);
	    }

	    public CursadaResponseDto toResponseDto(Cursada cursada) {
	        CursadaResponseDto dto = new CursadaResponseDto();

	        dto.setId(cursada.getId());
	        dto.setAlumnoId(cursada.getAlumno().getId());
	        dto.setMateriaId(cursada.getMateria().getId());
	        dto.setAnioLectivoId(cursada.getAnioLectivo().getId());
	        dto.setCondicionFinalId(cursada.getCondicionFinal().getId());

	        return dto;
	    }
	}

