package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.repository.AsignacionDocenteRepository;
import com.imb2025.calificaciones.service.IAsignacionDocenteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionDocenteServiceImpl implements IAsignacionDocenteService {

    @Autowired
    private AsignacionDocenteRepository repository;

    public List<AsignacionDocente> findAll() {
        return repository.findAll();
    }

    public AsignacionDocente findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public AsignacionDocente create(AsignacionDocente asignacionDocente) {
        return repository.save(asignacionDocente);
    }

    public AsignacionDocente update(AsignacionDocente asignacionDocente, Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception(
                    "Can't update AsignacionDocente with id: " + id + " because it does not exist");
        }
        asignacionDocente.setId(id);
        return repository.save(asignacionDocente);
    }

    public void deleteById(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception(
                    "Can't delete AsignacionDocente with id: " + id + " because it does not exist");
        }
        repository.deleteById(id);
    }
}
