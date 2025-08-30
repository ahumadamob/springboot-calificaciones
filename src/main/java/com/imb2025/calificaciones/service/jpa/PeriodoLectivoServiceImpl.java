package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.PeriodoLectivoRequestDto;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.PeriodoLectivoRepository;
import com.imb2025.calificaciones.service.IPeriodoLectivoService;

@Service
public class PeriodoLectivoServiceImpl implements IPeriodoLectivoService{

    @Autowired
    private PeriodoLectivoRepository repository;

    @Override
    public List<PeriodoLectivo> findAll() {
        return repository.findAll();
    }

    @Override
    public PeriodoLectivo findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Entidad no encontrada con id " + id));
    }

    @Override
    public PeriodoLectivo create(PeriodoLectivo periodoLectivo) {
        return repository.save(periodoLectivo);
    }

    @Override
    public PeriodoLectivo update(PeriodoLectivo periodoLectivo, Long id) {
    	if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
        }
        periodoLectivo.setId(id);
        return repository.save(periodoLectivo);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public PeriodoLectivo fromDto(PeriodoLectivoRequestDto requestDTO) {
        PeriodoLectivo periodoLectivo = new PeriodoLectivo();

        periodoLectivo.setNombre(requestDTO.getNombre());
        periodoLectivo.setFechaInicio(requestDTO.getFechaInicio());
        periodoLectivo.setFechaFin(requestDTO.getFechaFin());

        return periodoLectivo;
    }

}
