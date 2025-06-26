package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.dto.TipoEvaluacionRequestDTO;
import com.imb2025.calificaciones.entity.TipoEvaluacion;

public interface ITipoEvaluacionService {

	List<TipoEvaluacion> findAll();
	TipoEvaluacion findById(Long id);
	TipoEvaluacion create(TipoEvaluacion tipoevaluacion);
	void deleteById(Long id);
	TipoEvaluacion update(Long id, TipoEvaluacion tipoEvaluacion);
	boolean existsById(Long id);

}
 