package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.EvaluacionRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.TipoEvaluacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Evaluacion;
import com.imb2025.calificaciones.repository.EvaluacionRepository;
import com.imb2025.calificaciones.service.IEvaluacionService;

import java.util.List;

@Service
public class EvaluacionServiceImpl implements IEvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;
    @Autowired
    private TipoEvaluacionRepository tipoEvaluacionRepository;
    @Autowired
    private MateriaRepository materiaRepository;
    @Autowired
    private ComisionRepository comisionRepository;

    @Override
    public List<Evaluacion> findAll() {
        return evaluacionRepository.findAll();
    }

    @Override
    public Evaluacion findById(Long id) {
        return evaluacionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evaluación "+id+" no encontrada"));
    }

    @Override
    @Transactional
    public Evaluacion create(Evaluacion evaluacion) throws Exception {
        try {
            return evaluacionRepository.save(evaluacion);

        } catch (Exception e) {
            throw new Exception("Error al guardar la evaluación: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Evaluacion update(Evaluacion newEvaluacion, Long id) throws Exception {
        if (id == null) {
            throw new Exception("No se pudo identificar el id");
        }
        Evaluacion evaluacion = evaluacionRepository.findById(id)
                .orElseThrow(() -> new Exception("Evaluación no encontrada"));

        evaluacion.setComision(newEvaluacion.getComision());
        evaluacion.setMateria(newEvaluacion.getMateria());
        evaluacion.setFecha(newEvaluacion.getFecha());
        evaluacion.setTipoEvaluacion(newEvaluacion.getTipoEvaluacion());

        return evaluacionRepository.save(evaluacion);
    }

    // Pasar de DTO a entidad
    @Override
    public Evaluacion fromDto(EvaluacionRequestDto evaluacionRequestDto) throws Exception {
        if (evaluacionRequestDto == null) {
            throw new Exception("Evaluación no puede ser nula");
        }
        Evaluacion evaluacion = new Evaluacion();

        if (evaluacionRequestDto.getTipoEvaluacionId() != null) {
            TipoEvaluacion tipoEvaluacion = tipoEvaluacionRepository
                    .findById(evaluacionRequestDto.getTipoEvaluacionId())
                    .orElseThrow(() -> new Exception(
                            "Tipo de evaluación no encontrado con id: " + evaluacionRequestDto.getTipoEvaluacionId()));
            evaluacion.setTipoEvaluacion(tipoEvaluacion);
        }

        if (evaluacionRequestDto.getMateriaId() != null) {
            Materia materia = materiaRepository.findById(evaluacionRequestDto.getMateriaId())
                    .orElseThrow(() -> new Exception(
                            "Materia no encontrada con id: " + evaluacionRequestDto.getMateriaId()));
            evaluacion.setMateria(materia);
        }

        if (evaluacionRequestDto.getComisionId() != null) {
            Comision comision = comisionRepository.findById(evaluacionRequestDto.getComisionId())
                    .orElseThrow(() -> new Exception(
                            "Comisión no encontrada con id: " + evaluacionRequestDto.getComisionId()));
            evaluacion.setComision(comision);
        }
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

    @Override
    public void deleteById(Long id) throws Exception {
        if (!evaluacionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Evaluacion "+id+" no encontrada");
        }
        evaluacionRepository.deleteById(id);
    }

}
