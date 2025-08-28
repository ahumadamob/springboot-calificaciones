package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imb2025.calificaciones.dto.TipoNotaRequestDto;
import com.imb2025.calificaciones.entity.TipoNota;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.TipoNotaRepository;
import com.imb2025.calificaciones.service.ITipoNotaService;

@Service
public class TipoNotaServiceImpl implements ITipoNotaService {

    @Autowired
    private TipoNotaRepository tipoNotaRepository;

    @Override
    public List<TipoNota> findAll() {
        return tipoNotaRepository.findAll();
    }

    @Override
    public TipoNota findById(Long id) {
    	return tipoNotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entidad no encontrada con id " + id));
    }

    @Override
    public TipoNota create(TipoNota tipoNota) {
        try {
            return tipoNotaRepository.save(tipoNota);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar TipoNota: " + e.getMessage());
        }
    }

    @Override
    public TipoNota update(TipoNota tipoNota, Long id) {
        if (!tipoNotaRepository.existsById(id)) {
            throw new ResourceNotFoundException("TipoNota no encontrada con id: " + id);
        }
        tipoNota.setId(id);
        return tipoNotaRepository.save(tipoNota);
    }

    @Override
    public void deleteById(Long id) {
        if (!tipoNotaRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar el id: " + id + " porque no existe");
        }
        tipoNotaRepository.deleteById(id);
    }

    @Override
    public TipoNota fromDto(TipoNotaRequestDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El dto de tipo nota no puede ser nulo");
        }
        TipoNota tipoNota = new TipoNota();
        tipoNota.setNombre(dto.getNombre());
        tipoNota.setDescripcion(dto.getDescripcion());
        return tipoNota;
    }
}
