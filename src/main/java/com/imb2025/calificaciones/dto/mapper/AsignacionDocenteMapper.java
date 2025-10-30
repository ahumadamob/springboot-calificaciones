package com.imb2025.calificaciones.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.AsignacionDocenteRequestDto;
import com.imb2025.calificaciones.dto.response.AsignacionDocenteResponseDto;
import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.PeriodoLectivoRepository;

@Component
public class AsignacionDocenteMapper {

	@Autowired
	private DocenteRepository docenteRepository;

	@Autowired
	private MateriaRepository materiaRepository;

	@Autowired
	private ComisionRepository comisionRepository;

	@Autowired
	private PeriodoLectivoRepository periodoLectivoRepository;

	public AsignacionDocente fromDto(AsignacionDocenteRequestDto dto) throws Exception {
		Docente docente = docenteRepository.findById(dto.getDocenteId())
				.orElseThrow(() -> new Exception("Docente no encontrado con id: " + dto.getDocenteId()));
		Materia materia = materiaRepository.findById(dto.getMateriaId())
				.orElseThrow(() -> new Exception("Materia no encontrada con id: " + dto.getMateriaId()));
		Comision comision = comisionRepository.findById(dto.getComisionId())
				.orElseThrow(() -> new Exception("Comision no encontrada con id: " + dto.getComisionId()));
		PeriodoLectivo periodoLectivo = periodoLectivoRepository.findById(dto.getPeriodoLectivoId())
				.orElseThrow(() -> new Exception("Periodo lectivo no encontrado con id: " + dto.getPeriodoLectivoId()));
		return new AsignacionDocente(docente, materia, comision, periodoLectivo);
	}

	public AsignacionDocenteResponseDto toResponse(AsignacionDocente asignacion) {
		AsignacionDocenteResponseDto dto = new AsignacionDocenteResponseDto();

		dto.setId(asignacion.getId());
		dto.setDocenteId(asignacion.getDocente().getId());
		dto.setMateriaId(asignacion.getMateria().getId());
		dto.setComisionId(asignacion.getComision().getId());
		dto.setPeriodoLectivoId(asignacion.getPeriodoLectivo().getId());
		dto.setVersion(asignacion.getVersion());

		return dto;
	}
}
