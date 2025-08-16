package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.service.IComisionService;

@Service
public class ComisionServiceImpl implements IComisionService{

    @Autowired
    private ComisionRepository repository;

    @Override
    public List<Comision> findAll() {
         return repository.findAll();
    }

    @Override
    public Comision findById(Long id) {
         return repository.findById(id).orElse(null);
    }

    @Override
    public Comision save(Comision Comision) {
         return repository.save(Comision);
    }

    @Override
    public Comision update(Comision Comision, Long id) {
        Comision.setId(id);
        return repository.save(Comision);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }
}
