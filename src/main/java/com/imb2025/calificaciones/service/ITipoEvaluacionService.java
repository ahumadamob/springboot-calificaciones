package com.imb2025.calificaciones.service;

import java.util.List;
import com.imb2025.calificaciones.entity.TipoEvaluacion;

public interface ITipoEvaluacionService {

	List<TipoEvaluacion> findAll();
	TipoEvaluacion findById(Long id);
	TipoEvaluacion save(TipoEvaluacion tipoevaluacion);
	void deleteById(Long id);

}
 