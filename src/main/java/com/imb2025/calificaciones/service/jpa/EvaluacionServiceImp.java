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
public class EvaluacionServiceImp implements IEvaluacionService{
	
	@Autowired
	private EvaluacionRepository evaluacionRepository;
	private TipoEvaluacionRepository tipoEvaluacionRepository;
	private MateriaRepository materiaRepository;
	private ComisionRepository comisionRepository;
	
	@Override
	public List<Evaluacion> findAll(){
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

			Optional<TipoEvaluacion> tipoEvaluacion =
					tipoEvaluacionRepository.findById(evaluacionRequestDTO.getTipoEvaluacionId());

			if (!tipoEvaluacion.isPresent()){
				throw new RuntimeException("Tipo de evaluacion no encontrado");
			}
			evaluacion.setTipoEvaluacionId(evaluacionRequestDTO.getTipoEvaluacionId());
			//----------------
			Optional<Materia> materia = materiaRepository.findById(evaluacionRequestDTO.getMateriaId());
			if (!materia.isPresent()){
				throw new RuntimeException("Materia no encontrada");
			}
			evaluacion.setMateriaId(evaluacionRequestDTO.getMateriaId());

			//----------------
			Optional<Comision> comision =
					comisionRepository.findById(evaluacionRequestDTO.getComisionId());
			if (!comision.isPresent()){
				throw new RuntimeException("Comision no encontrado");
			}
			evaluacion.setComisionId(evaluacionRequestDTO.getComisionId());

			evaluacion.setFechaEvaluacion(evaluacionRequestDTO.getFechaEvaluacion());

			return evaluacionRepository.save(evaluacion);

		}catch (Exception e){
			throw  new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public Evaluacion update(Long id, EvaluacionRequestDTO newEvaluacionDTO) {
		try {
			Evaluacion evaluacion = new Evaluacion();

			Optional<TipoEvaluacion> tipoEvaluacion =
					tipoEvaluacionRepository.findById(newEvaluacionDTO.getTipoEvaluacionId());

			if (!tipoEvaluacion.isPresent()){
				throw new RuntimeException("Tipo de evaluacion no encontrado");
			}
			evaluacion.setTipoEvaluacionId(newEvaluacionDTO.getTipoEvaluacionId());
			//----------------
			Optional<Materia> materia = materiaRepository.findById(newEvaluacionDTO.getMateriaId());
			if (!materia.isPresent()){
				throw new RuntimeException("Materia no encontrada");
			}
			evaluacion.setMateriaId(newEvaluacionDTO.getMateriaId());

			//----------------
			Optional<Comision> comision =
					comisionRepository.findById(newEvaluacionDTO.getComisionId());
			if (!comision.isPresent()){
				throw new RuntimeException("Comision no encontrado");
			}
			evaluacion.setComisionId(newEvaluacionDTO.getComisionId());

			evaluacion.setFechaEvaluacion(newEvaluacionDTO.getFechaEvaluacion());

			return evaluacionRepository.save(evaluacion);

		}catch (Exception e){
			throw  new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public void deleteById(Long id) {
		evaluacionRepository.deleteById(id);
	}

}
