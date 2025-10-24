package com.imb2025.calificaciones.service;

import com.imb2025.calificaciones.entity.EstadoEvaluacion;
import java.util.List;

public interface IEstadoEvaluacionService {

    public List<EstadoEvaluacion> findAll();

    public EstadoEvaluacion create(EstadoEvaluacion estadoEvaluacion);

    public EstadoEvaluacion update(EstadoEvaluacion estadoEvaluacion, Long id) throws Exception;

    public EstadoEvaluacion findById(Long id);

    public void deleteById(Long id) throws Exception;

    public List<EstadoEvaluacion> findByNombre(String nombre);

    public long countByDescripcion(String descripcion);

    public long countByResultado(EstadoEvaluacion.ResultadoEvaluacion resultado);
}
