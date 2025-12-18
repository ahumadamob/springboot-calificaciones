package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.mapper.TipoEvaluacionMapper;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.entity.TipoEvaluacionEnum;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.TipoEvaluacionRepository;
import com.imb2025.calificaciones.service.ITipoEvaluacionService;


@Service
public class TipoEvaluacionServiceImpl implements ITipoEvaluacionService {

    @Autowired
    private TipoEvaluacionRepository repo;
    
    @Autowired
    private TipoEvaluacionMapper mapper;

    @Override
    public List<TipoEvaluacion> findAll() {
        return repo.findAll();
    }

    @Override
    public TipoEvaluacion findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontró el Tipo de Evaluacion con ID " + id));
    }

    @Override
    public TipoEvaluacion create(TipoEvaluacion tipoevaluacion) {
        return repo.save(tipoevaluacion);
    }

    @Override
    public TipoEvaluacion update(TipoEvaluacion tipoEvaluacion, Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("No se puede actualizar: TipoEvaluacion con ID " + id + " no existe");
        }
        tipoEvaluacion.setId(id);
        return repo.save(tipoEvaluacion);
    }

    @Override
    public void deleteById(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException(
                    "No se puede eliminar: TipoEvaluacion con ID " + id + " no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public List<TipoEvaluacion> buscarNombre(String q) {
        return repo.findByNombreContainingIgnoreCase(q);
    }

    @Override
    public long contarNombre(String q) {
        return repo.countByNombreContainingIgnoreCase(q);
    }
    
    @Override
    public List<TipoEvaluacion> listarCategoriaAlta() {
	    return repo.findByCategoria(TipoEvaluacionEnum.ALTA);
	}

    @Override
	public List<TipoEvaluacion> listarCategoriaMedia() {
	    return repo.findByCategoria(TipoEvaluacionEnum.MEDIA);
	}

    @Override
	public List<TipoEvaluacion> listarCategoriaBaja() {
	    return repo.findByCategoria(TipoEvaluacionEnum.BAJA);
	}
}
