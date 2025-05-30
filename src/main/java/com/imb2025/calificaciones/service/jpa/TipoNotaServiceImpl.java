package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return tipoNotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoNota no encontrada con id: " + id));
    }


    @Override
    public TipoNota save(TipoNota tipoNota) {
        return tipoNotaRepository.save(tipoNota);
    }

    @Override
    public TipoNota update(Long id, TipoNota tipoNota) {
        Optional<TipoNota> existente = tipoNotaRepository.findById(id);
        if (existente.isPresent()) {
            TipoNota t = existente.get();
            t.setNombre(tipoNota.getNombre());
            t.setDescripcion(tipoNota.getDescripcion());
            return tipoNotaRepository.save(t);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        tipoNotaRepository.deleteById(id);
    }
}
