package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.PlanEstudio;
import com.imb2025.calificaciones.repository.PlanEstudioRepository;
import com.imb2025.calificaciones.service.IPlanEstudioService;

@Service 
public class PlanEstudioServiceImp implements IPlanEstudioService {

    @Autowired
    private PlanEstudioRepository repository;

    @Override
    public List<PlanEstudio> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PlanEstudio> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PlanEstudio save(PlanEstudio planEstudio) {
        return repository.save(planEstudio);
    }

    @Override
    public PlanEstudio update(Long id, PlanEstudio planEstudio) {
        Optional<PlanEstudio> existing = repository.findById(id);
        if (existing.isPresent()) {
            PlanEstudio plan = existing.get();
            plan.setNombre(planEstudio.getNombre()); 
            return repository.save(plan);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
