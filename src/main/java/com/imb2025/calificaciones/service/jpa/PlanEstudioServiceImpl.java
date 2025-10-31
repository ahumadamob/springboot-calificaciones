package com.imb2025.calificaciones.service.jpa;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.request.PlanEstudioRequestDto;
import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.repository.PlanEstudioRepository;
import com.imb2025.calificaciones.service.IPlanEstudioService;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PlanEstudioServiceImpl implements IPlanEstudioService {

    @Autowired
    private PlanEstudioRepository planestudiorepository;

    
    @Override
    public List<PlanEstudio> findAll() {
        return planestudiorepository.findAll();
    }

    @Override
    public PlanEstudio findById(Long id) {
        return planestudiorepository.findById(id) .orElseThrow(() -> new ResourceNotFoundException(
        "Entidad no encontrada con id " + id));
    }


	@Override
	public List<PlanEstudio> findAllByNombre(String nombre) {
		
		return planestudiorepository.findByNombreContainingIgnoreCase(nombre);
    }
		
	@Override
	public long countByCarrera(Long carreraId){
	    return planestudiorepository.countByCarrera_Id(carreraId);
	}
	
	@Override
    public PlanEstudio create(PlanEstudio planestudio) {
        return planestudiorepository.save(planestudio);
    }

	@Override
	public PlanEstudio update(PlanEstudio planestudio, Long id) {
	    if (!planestudiorepository.existsById(id)) {
	        throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
	    }
    	planestudio.setId(id);
        return planestudiorepository.save(planestudio);
    }

    @Override
    public void deleteById(Long id) {
        if (!planestudiorepository.existsById(id)) {
            throw new ResourceNotFoundException("Entidad no encontrada con id " + id);
        }
        planestudiorepository.deleteById(id);
    }
	
	
}