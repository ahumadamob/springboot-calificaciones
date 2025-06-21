package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.EvaluacionRequestDTO;
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
public class EvaluacionServiceImp implements IEvaluacionService {

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
	public Evaluacion save(EvaluacionRequestDTO evaluacionRequestDTO) {
		try {
			Evaluacion evaluacion = new Evaluacion();

			if (evaluacionRequestDTO.getTipoEvaluacionId() != null) {
				Optional<TipoEvaluacion> tipoEvaluacion = tipoEvaluacionRepository
						.findById(evaluacionRequestDTO.getTipoEvaluacionId());
				if (!tipoEvaluacion.isPresent()) {
					throw new RuntimeException("Tipo de evaluacion no encontrado");
				}
				evaluacion.setTipoEvaluacion(tipoEvaluacion.get());
			}

			if (evaluacionRequestDTO.getMateriaId() != null) {
				Optional<Materia> materia = materiaRepository.findById(evaluacionRequestDTO.getMateriaId());
				if (!materia.isPresent()) {
					throw new RuntimeException("Materia no encontrada");
				}
				evaluacion.setMateria(materia.get());
			}

			if (evaluacionRequestDTO.getComisionId() != null) {
				Optional<Comision> comision = comisionRepository.findById(evaluacionRequestDTO.getComisionId());
				if (!comision.isPresent()) {
					throw new RuntimeException("Comision no encontrada");
				}
				evaluacion.setComision(comision.get());
			}

			evaluacion.setFechaEvaluacion(evaluacionRequestDTO.getFechaEvaluacion());

			return evaluacionRepository.save(evaluacion);

		} catch (Exception e) {
			throw new RuntimeException("Error al guardar la evaluación: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public Evaluacion update(Long id, EvaluacionRequestDTO newEvaluacionDTO) {
		try {
			Evaluacion evaluacion = evaluacionRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));

			if (newEvaluacionDTO.getTipoEvaluacionId() != null) {
				Optional<TipoEvaluacion> tipoEvaluacion = tipoEvaluacionRepository
						.findById(newEvaluacionDTO.getTipoEvaluacionId());
				if (!tipoEvaluacion.isPresent()) {

					throw new RuntimeException("Tipo de evaluacion no encontrado");
				}
				evaluacion.setTipoEvaluacion(tipoEvaluacion.get());
			}
			if (newEvaluacionDTO.getMateriaId() != null) {
				Optional<Materia> materia = materiaRepository.findById(newEvaluacionDTO.getMateriaId());
				if (!materia.isPresent()) {
					throw new RuntimeException("Materia no encontrada");
				}
				evaluacion.setMateria(materia.get());
			}

			if (newEvaluacionDTO.getComisionId() != null) {
				Optional<Comision> comision = comisionRepository.findById(newEvaluacionDTO.getComisionId());
				if (!comision.isPresent()) {
					throw new RuntimeException("Comision no encontrada");
				}
				evaluacion.setComision(comision.get());
			}

			evaluacion.setFechaEvaluacion(newEvaluacionDTO.getFechaEvaluacion());
			return evaluacionRepository.save(evaluacion);
		} catch (Exception e) {
			throw new RuntimeException("Error al actualizar la evaluación: " + e.getMessage());
		}
	}

	@Override
	public void deleteById(Long id) {
		evaluacionRepository.deleteById(id);
	}

}
