package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.TipoEvaluacionRequestDto;
import com.imb2025.calificaciones.entity.TipoEvaluacion;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.TipoEvaluacionRepository;
import com.imb2025.calificaciones.service.ITipoEvaluacionService;

@Service
public class TipoEvaluacionServiceImpl implements ITipoEvaluacionService {

    @Autowired
    private TipoEvaluacionRepository repo;

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
    public TipoEvaluacion fromDto(TipoEvaluacionRequestDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El  DATO de tipo evaluación no puede ser nulo");
        }

        TipoEvaluacion tipo = new TipoEvaluacion();
        tipo.setNombre(dto.getNombre());
        tipo.setDescripcion(dto.getDescripcion());
    
        
        if(dto.getEstado() != null && !dto.getEstado().isBlank()) {
        	try {
        		tipo.setEstado(TipoEvaluacion.Estado.valueOf(dto.getEstado().trim().toUpperCase()));
        	}catch(IllegalArgumentException e) {
        		throw new IllegalArgumentException("El estado debe ser ACTIVO o INACTIVO");
        	}
        }else {
        	tipo.setEstado(TipoEvaluacion.Estado.ACTIVO);        
    }
        return tipo;
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
    public long contarActivos() {
    	return repo.countByEstado(TipoEvaluacion.Estado.ACTIVO);
    }
    
    @Override
    public long contarInactivos() {
    	return repo.countByEstado(TipoEvaluacion.Estado.INACTIVO);
    }

}
