package com.imb2025.calificaciones.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.InscripcionMateriaRequestDto;
import com.imb2025.calificaciones.dto.response.InscripcionMateriaResponseDto;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.PeriodoLectivoRepository;

@Component
public class InscripcionMateriaMapper {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private PeriodoLectivoRepository periodoLectivoRepository;

    @Autowired
    private PeriodoLectivoMapper periodoLectivoMapper;

    public InscripcionMateria fromDto(InscripcionMateriaRequestDto inscripcionMateriaDto) throws Exception {
        InscripcionMateria inscripcionMateria = new InscripcionMateria();

        Alumno alumno = alumnoRepository.findById(inscripcionMateriaDto.getAlumnoId())
                .orElseThrow(() -> new Exception("Alumno no encontrado con ID: " + inscripcionMateriaDto.getAlumnoId()));
        inscripcionMateria.setAlumno(alumno);

        Materia materia = materiaRepository.findById(inscripcionMateriaDto.getMateriaId())
                .orElseThrow(() -> new Exception("Materia no encontrada con ID: " + inscripcionMateriaDto.getMateriaId()));
        inscripcionMateria.setMateria(materia);

        PeriodoLectivo periodoLectivo = periodoLectivoRepository.findById(inscripcionMateriaDto.getPeriodoLectivoId())
                .orElseThrow(() -> new Exception("Periodo Lectivo no encontrado con ID: " + inscripcionMateriaDto.getPeriodoLectivoId()));
        inscripcionMateria.setPeriodoLectivo(periodoLectivo);

        return inscripcionMateria;
    }

    public InscripcionMateriaResponseDto toResponseDto(InscripcionMateria inscripcionMateria) {
        InscripcionMateriaResponseDto dto = new InscripcionMateriaResponseDto();
        dto.setId(inscripcionMateria.getId());
        dto.setVersion(inscripcionMateria.getVersion());

        // placeholders hasta que existan los mappers de alumno y materia
        dto.setAlumno(null);
        dto.setMateria(null);
        dto.setPeriodoLectivo(periodoLectivoMapper.toResponse(inscripcionMateria.getPeriodoLectivo()));
        return dto;
    }
}
