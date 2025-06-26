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
	public Evaluacion save(Evaluacion evaluacion) {
		try {
			return evaluacionRepository.save(evaluacion);

		} catch (Exception e) {
			throw new RuntimeException("Error al guardar la evaluación: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public Evaluacion update(Long id, Evaluacion newEvaluacion) {
		try {
			if (id == null) {
				throw new RuntimeException("No se pudo identificar el id");
			}

			Evaluacion evaluacion = evaluacionRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));

			
			evaluacion.setComision(newEvaluacion.getComision());
			evaluacion.setMateria(newEvaluacion.getMateria());
			evaluacion.setFechaEvaluacion(newEvaluacion.getFechaEvaluacion());
			evaluacion.setTipoEvaluacion(newEvaluacion.getTipoEvaluacion());

			return evaluacionRepository.save(evaluacion);

		} catch (Exception e) {
			throw new RuntimeException("Error al actualizar la evaluación: " + e.getMessage());
		}
	}

	// Pasar de DTO a entidad
	@Override
	public Evaluacion convertToEntity(EvaluacionRequestDTO evaluacionRequestDTO) {
		try {
			if (evaluacionRequestDTO == null) {
				throw new RuntimeException("Evaluación no puede ser nula");
			}
			Evaluacion evaluacion = new Evaluacion();

			if (evaluacionRequestDTO.getTipoEvaluacionId() != null) {
				TipoEvaluacion tipoEvaluacion = tipoEvaluacionRepository
						.findById(evaluacionRequestDTO.getTipoEvaluacionId()).orElse(null);
				if (tipoEvaluacion == null) {
					throw new RuntimeException("Tipo de evaluación no encontrado");
				}
				evaluacion.setTipoEvaluacion(tipoEvaluacion);
			}

			if (evaluacionRequestDTO.getMateriaId() != null) {
				Materia materia = materiaRepository.findById(evaluacionRequestDTO.getMateriaId()).orElse(null);
				if (materia == null) {
					throw new RuntimeException("Materia no encontrada");
				}
				evaluacion.setMateria(materia);
			}

			if (evaluacionRequestDTO.getComisionId() != null) {
				Comision comision = comisionRepository.findById(evaluacionRequestDTO.getComisionId()).orElse(null);
				if (comision == null) {
					throw new RuntimeException("Comisión no encontrada");
				}
				evaluacion.setComision(comision);
			}
			evaluacion.setId(evaluacionRequestDTO.getId());
			evaluacion.setFechaEvaluacion(evaluacionRequestDTO.getFechaEvaluacion());
			return evaluacion;
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}

	}

	@Override
	public void deleteById(Long id) {
		evaluacionRepository.deleteById(id);
	}

}
