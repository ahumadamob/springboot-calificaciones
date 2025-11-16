package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.CalendarioMateria;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.ICalendarioMateriaRepository;
import com.imb2025.calificaciones.service.ICalendarioMateriaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarioMateriaServiceImpl implements ICalendarioMateriaService {

    @Autowired
    private ICalendarioMateriaRepository calMatRepo;
    @Override
    public List<CalendarioMateria> findAll() {
        return calMatRepo.findAll();
    }

    @Override
    @Transactional
    public CalendarioMateria findById(Long id) {
        return calMatRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Calendario materia no encontrado con id: " + id));
    }

    @Override
    public CalendarioMateria create(CalendarioMateria calendarioMateria) {
        return calMatRepo.save(calendarioMateria);
    }

    @Override
    public CalendarioMateria update(CalendarioMateria calendarioMateria, Long id) {
        calMatRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calendario materia no encontrado con id: " + id));
        calendarioMateria.setId(id);
        return calMatRepo.save(calendarioMateria);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        calMatRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calendario materia no encontrado con id: " + id));
        calMatRepo.deleteById(id);
    }

    @Override
    public List<CalendarioMateria> findByMateriaId(Long materiaId) {
        return calMatRepo.findByMateriaId(materiaId);
    }

    @Override
    public Long countByComisionId(Long comisionId) {
        return calMatRepo.countByComisionId(comisionId).orElseThrow(() -> new EntityNotFoundException("No hay calendarios" +
                "materias para la comision: " + comisionId));
    }


}
