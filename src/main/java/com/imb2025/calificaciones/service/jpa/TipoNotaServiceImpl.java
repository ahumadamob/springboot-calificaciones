package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.TipoNotaRequestDto;
import com.imb2025.calificaciones.entity.TipoNota;
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
        return tipoNotaRepository.findById(id).orElse(null);
    }

    @Override
    public TipoNota save(TipoNota tipoNota) {
        try {
            return tipoNotaRepository.save(tipoNota);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar TipoNota: " + e.getMessage());
        }
    }

    @Override
    public TipoNota update(TipoNota tipoNota, Long id) {
        try {
            TipoNota existente = tipoNotaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("TipoNota no encontrada con id: " + id));

            existente.setNombre(tipoNota.getNombre());
            existente.setDescripcion(tipoNota.getDescripcion());
            return tipoNotaRepository.save(existente);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar TipoNota: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        tipoNotaRepository.deleteById(id);
    }

    @Override
    public TipoNota fromDto(TipoNotaRequestDto dto) throws Exception {
        if (dto == null) {
            throw new Exception("El dto de tipo nota no puede ser nulo");
        }
        TipoNota tipoNota = new TipoNota();
        tipoNota.setNombre(dto.getNombre());
        tipoNota.setDescripcion(dto.getDescripcion());
        return tipoNota;
    }
}
