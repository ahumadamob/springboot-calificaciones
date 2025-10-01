package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.ObraSocialRequestDto;
import com.imb2025.calificaciones.entity.ObraSocial;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.ObraSocialRepository;
import com.imb2025.calificaciones.service.IObraSocialService;

import jakarta.transaction.Transactional;

@Service
public class ObraSocialServiceImpl implements IObraSocialService {

    @Autowired
    private ObraSocialRepository obraSocialRepository;

    @Override
    public List<ObraSocial> findAll() {
        return obraSocialRepository.findAll();
    }

    @Override
    public ObraSocial findById(Long id) {
        return obraSocialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Obra social con id " + id + " no encontrada"));
    }

    @Override
    @Transactional
    public ObraSocial create(ObraSocial obraSocial) {
        return obraSocialRepository.save(obraSocial);
    }

    @Override
    @Transactional
    public ObraSocial update(ObraSocial obraSocial, Long id) throws Exception {
        if (id == null) {
            throw new Exception("No se pudo identificar el id");
        }

        ObraSocial existente = obraSocialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Obra social con id " + id + " no encontrada"));

        existente.setNombre(obraSocial.getNombre());
        existente.setDescripcion(obraSocial.getDescripcion());
        existente.setTelefonoContacto(obraSocial.getTelefonoContacto());

        return obraSocialRepository.save(existente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!obraSocialRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar el id: " + id + " porque no existe");
        }
        obraSocialRepository.deleteById(id);
    }

    @Override
    public ObraSocial fromDto(ObraSocialRequestDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO de obra social no puede ser nulo");
        }

        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setNombre(dto.getNombre());
        obraSocial.setDescripcion(dto.getDescripcion());
        obraSocial.setTelefonoContacto(dto.getTelefonoContacto());
        return obraSocial;
    }
}
