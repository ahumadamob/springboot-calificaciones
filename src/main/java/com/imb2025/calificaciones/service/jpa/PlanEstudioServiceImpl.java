package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.exception.EntidadNoEncontradaException;
import com.imb2025.calificaciones.dto.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.Carrera;
import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.repository.CarreraRepository;
import com.imb2025.calificaciones.repository.PlanEstudioRepository;
import com.imb2025.calificaciones.service.IPlanEstudioService;

import jakarta.transaction.Transactional;

@Service
public class PlanEstudioServiceImpl implements IPlanEstudioService {

    @Autowired
    private PlanEstudioRepository planestudiorepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    /*private AnioVigenciaRepository aniovigenciaRepository;*/

    @Override
    public List<PlanEstudio> findAll() {
        return planestudiorepository.findAll();
    }

    @Override
    public PlanEstudio findById(Long id) {
        return planestudiorepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public PlanEstudio create(PlanEstudio planEstudio) {
        return planestudiorepository.save(planEstudio);
    }

    @Override
    @Transactional
    public PlanEstudio update(PlanEstudio newPlanEstudio, Long id) {
        try {
            PlanEstudio existente = findById(id);
            if (existente == null) {
                throw new EntidadNoEncontradaException("Plan de estudio con ID " + id + " no encontrado");
            }

            // Validar existencia de carrera
            if (newPlanEstudio.getCarrera() == null ||
                newPlanEstudio.getCarrera().getId() == null ||
                !carreraRepository.existsById(newPlanEstudio.getCarrera().getId())) {
                Long carreraId = newPlanEstudio.getCarrera() != null ? newPlanEstudio.getCarrera().getId() : null;
                throw new EntidadNoEncontradaException("Carrera con ID " + carreraId + " no existe");
            }

            /*
            // Validar existencia de anio vigencia
            if (newPlanEstudio.getAnioVigencia() == null ||
                !anioVigenciaRepository.existsById(newPlanEstudio.getAnioVigencia()) {
                throw new EntidadNoEncontradaException("Año de vigencia con ID " + newPlanEstudio.getAnioVigencia() + " no existe");
            }
            */

            // Actualizar campos
            existente.setCarrera(newPlanEstudio.getCarrera());
            existente.setNombre(newPlanEstudio.getNombre());
            existente.setAnioVigencia(newPlanEstudio.getAnioVigencia());

            return planestudiorepository.save(existente);
        } catch (EntidadNoEncontradaException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el plan estudio: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        planestudiorepository.deleteById(id);
    }

    @Override
    public PlanEstudio fromDto(PlanEstudioRequestDto dto) throws Exception {
        if (dto == null) {
            throw new Exception("El DTO no puede ser nulo");
        }

        PlanEstudio plan = new PlanEstudio();

        Carrera carrera = carreraRepository.findById(dto.getCarreraId())
            .orElseThrow(() -> new Exception("Carrera con ID " + dto.getCarreraId() + " no encontrada"));
        plan.setCarrera(carrera);

        if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
            throw new Exception("El nombre no puede ser nulo o vacío");
        }
        plan.setNombre(dto.getNombre());
        plan.setAnioVigencia(dto.getAnioVigencia());
        return plan;
    }

    public PlanEstudio convertToEntity(PlanEstudioRequestDto dto) {
        try {
            return fromDto(dto);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir PlanEstudio: " + e.getMessage());
        }
    }
}
