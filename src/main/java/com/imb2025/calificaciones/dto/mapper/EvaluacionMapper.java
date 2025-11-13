package com.imb2025.calificaciones.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imb2025.calificaciones.dto.request.EvaluacionRequestDto;
import com.imb2025.calificaciones.dto.response.EvaluacionResponseDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Evaluacion;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.TipoEvaluacionRepository;

@Component
public class EvaluacionMapper {

    @Autowired
    private TipoEvaluacionRepository tipoEvaluacionRepository;
    @Autowired
    private MateriaRepository materiaRepository;
    @Autowired
    private ComisionRepository comisionRepository;

    public Evaluacion fromDto(EvaluacionRequestDto evaluacionRequestDto) throws Exception {
        if (evaluacionRequestDto == null) {
            throw new Exception("Evaluación no puede ser nula");
        }

        Evaluacion evaluacion = new Evaluacion();

        TipoEvaluacion tipoEvaluacion = tipoEvaluacionRepository
                .findById(evaluacionRequestDto.getTipoEvaluacionId())
                .orElseThrow(() -> new Exception(
                        "Tipo de evaluación no encontrado con id: " + evaluacionRequestDto.getTipoEvaluacionId()));
        evaluacion.setTipoEvaluacion(tipoEvaluacion);

        Materia materia = materiaRepository.findById(evaluacionRequestDto.getMateriaId())
                .orElseThrow(() -> new Exception(
                        "Materia no encontrada con id: " + evaluacionRequestDto.getMateriaId()));
        evaluacion.setMateria(materia);

        Comision comision = comisionRepository.findById(evaluacionRequestDto.getComisionId())
                .orElseThrow(() -> new Exception(
                        "Comisión no encontrada con id: " + evaluacionRequestDto.getComisionId()));
        evaluacion.setComision(comision);

        evaluacion.setFecha(evaluacionRequestDto.getFechaEvaluacion());
        return evaluacion;
    }

    public Evaluacion convertToEntity(EvaluacionRequestDto evaluacionRequestDto) {
        try {
            return fromDto(evaluacionRequestDto);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public EvaluacionResponseDto toResponseDto(Evaluacion evaluacion) {

        EvaluacionResponseDto evaluacionDto = new EvaluacionResponseDto();

        evaluacionDto.setFecha(evaluacion.getFecha());
        evaluacionDto.setComision(evaluacion.getComision());
        evaluacionDto.setMateria(evaluacion.getMateria());
        evaluacionDto.setTipoEvaluacion(evaluacion.getTipoEvaluacion());
        evaluacionDto.setId(evaluacion.getId());

        return evaluacionDto;
    }

    public List<EvaluacionResponseDto> toResponseList(List<Evaluacion> evaluaciones) {

        return evaluaciones.stream().map(this::toResponseDto).collect(Collectors.toList());
    }

}
