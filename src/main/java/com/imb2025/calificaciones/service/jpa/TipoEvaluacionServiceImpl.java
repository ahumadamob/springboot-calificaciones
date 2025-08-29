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
                .orElseThrow(() -> new RuntimeException("No se encontró el Tipo de Evaluacion con ID " + id));
    }

    @Override
    public TipoEvaluacion create(TipoEvaluacion tipoevaluacion) {
        return repo.save(tipoevaluacion);
    }

    @Override
    public TipoEvaluacion update(TipoEvaluacion tipoEvaluacion, Long id) throws Exception {
        if (repo.existsById(id)) {
        	throw new ResourceNotFoundException(
                    "No se puede actualizar TipoEvaluacion con ID " + id);
        }
        tipoEvaluacion.setId(id);
        return repo.save(tipoEvaluacion);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public TipoEvaluacion fromDto(TipoEvaluacionRequestDto dto) throws Exception {
        if (dto == null) {
            throw new Exception("El dto de tipo evaluación no puede ser nulo");
        }
        TipoEvaluacion tipo = new TipoEvaluacion();
        tipo.setNombre(dto.getNombre());
        tipo.setDescripcion(dto.getDescripcion());
        return tipo;
    }

}
