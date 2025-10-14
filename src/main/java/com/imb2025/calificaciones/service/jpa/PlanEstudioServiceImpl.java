package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.Carrera;
import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.repository.CarreraRepository;
import com.imb2025.calificaciones.repository.PlanEstudioRepository;
import com.imb2025.calificaciones.service.IPlanEstudioService;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
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
        return planestudiorepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException(
        "Entidad no encontrada con id " + id));
    }

    @Override
    @Transactional
    public PlanEstudio create(PlanEstudio planEstudio) {
        return planestudiorepository.save(planEstudio);
    }

    @Override
    @Transactional
    public PlanEstudio update(PlanEstudio newPlanEstudio, Long id) throws Exception {
       if (id == null) {
    	   throw new Exception ("No se pudo identificar el id");
       }
       PlanEstudio planestudio= planestudiorepository.findById(id)
    		  
    				    .orElseThrow(() -> new ResourceNotFoundException(
    				        "Entidad no encontrada con id " + id));

        
        if (newPlanEstudio.getCarrera() == null ||
                newPlanEstudio.getCarrera().getId() == null ||
                !carreraRepository.existsById(newPlanEstudio.getCarrera().getId())) {
            Long carreraId = newPlanEstudio.getCarrera() != null ? newPlanEstudio.getCarrera().getId() : null;
            throw new ResourceNotFoundException("Carrera con ID " + carreraId + " no existe");
        }

        planestudio.setCarrera(newPlanEstudio.getCarrera());
        planestudio.setNombre(newPlanEstudio.getNombre());
        planestudio.setAnioVigencia(newPlanEstudio.getAnioVigencia());

        return planestudiorepository.save(planestudio);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!planestudiorepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar el id: " + id + " porque no existe");
        }
        planestudiorepository.deleteById(id);
    }

    @Override
    public PlanEstudio fromDto(PlanEstudioRequestDto dto) throws Exception {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO no puede ser nulo");
        }

        PlanEstudio plan = new PlanEstudio();

        Carrera carrera = carreraRepository.findById(dto.getCarreraId())
            .orElseThrow(() -> new ResourceNotFoundException("Carrera con ID " + dto.getCarreraId() + " no encontrada"));
        plan.setCarrera(carrera);

        if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        plan.setNombre(dto.getNombre());
        
        return plan;
    }

    public PlanEstudio convertToEntity(PlanEstudioRequestDto dto) {
        try {
            return fromDto(dto);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir PlanEstudio: " + e.getMessage());
        }
    }

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}