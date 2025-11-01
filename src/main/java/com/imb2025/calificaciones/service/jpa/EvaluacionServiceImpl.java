package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Evaluacion;
import com.imb2025.calificaciones.repository.EvaluacionRepository;
import com.imb2025.calificaciones.service.IEvaluacionService;

import java.util.Date;
import java.util.List;

@Service
public class EvaluacionServiceImpl implements IEvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;
    // @Autowired
    // private TipoEvaluacionRepository tipoEvaluacionRepository;
    // @Autowired
    // private MateriaRepository materiaRepository;
    // @Autowired
    // private ComisionRepository comisionRepository;

    @Override
    public List<Evaluacion> findAll() {
        return evaluacionRepository.findAll();
    }

    @Override
    public Evaluacion findById(Long id) {
        return evaluacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evaluación " + id + " no encontrada"));
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

    @Override
    public void deleteById(Long id) throws Exception {
        if (!evaluacionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Evaluacion " + id + " no encontrada");
        }
        evaluacionRepository.deleteById(id);
    }

    @Override
    public List<Evaluacion> findByMateriaIdAndComisionId(long materiaId, long comisionId) {
        return evaluacionRepository.findByMateriaIdAndComisionId(materiaId, comisionId);
    }

    @Override
    public long countByMateriaIdAndComisionId(long materiaId, long comisionId) {
        return evaluacionRepository.countByMateriaIdAndComisionId(materiaId, comisionId);
    }

    @Override
    public List<Evaluacion> findByFechaBetween(Date fechaInicio, Date fechaFin) {
        return evaluacionRepository.findByFechaBetween(fechaInicio, fechaFin);
    }

}
