package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.EvaluacionRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.TipoEvaluacionRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
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
        return evaluacionRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Evaluacion save(Evaluacion evaluacion) {
        try {
            return evaluacionRepository.save(evaluacion);

        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la evaluación: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Evaluacion update(Evaluacion newEvaluacion, Long id) {
        try {
            if (id == null) {
                throw new RuntimeException("No se pudo identificar el id");
            }

            Evaluacion evaluacion = evaluacionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));

                        evaluacion.setComision(newEvaluacion.getComision());
                        evaluacion.setMateria(newEvaluacion.getMateria());
                        evaluacion.setFecha(newEvaluacion.getFecha());
                        evaluacion.setTipoEvaluacion(newEvaluacion.getTipoEvaluacion());

            return evaluacionRepository.save(evaluacion);

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la evaluación: " + e.getMessage());
        }
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
        evaluacion.setId(evaluacionRequestDto.getId());
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
    public void deleteById(Long id) {
        evaluacionRepository.deleteById(id);
    }

}
