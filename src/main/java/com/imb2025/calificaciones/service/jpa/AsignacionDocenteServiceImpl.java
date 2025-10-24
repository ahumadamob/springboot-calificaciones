package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.AsignacionDocenteRepository;
import com.imb2025.calificaciones.service.IAsignacionDocenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionDocenteServiceImpl implements IAsignacionDocenteService {

    @Autowired
    private AsignacionDocenteRepository repository;

    @Override
    public List<AsignacionDocente> findAll() {
        return repository.findAll();
    }

    @Override
    public List<AsignacionDocente> findAllByDocenteId(Long docenteId) {
        return repository.findByDocenteId(docenteId);
    }

    @Override
    public long countByMateriaIdAndComisionId(Long materiaId, Long comisionId) {
        return repository.countByMateriaIdAndComisionId(materiaId, comisionId);
    }

    @Override
    public AsignacionDocente findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Entidad no encontrada con id " + id));
    }

    @Override
    public AsignacionDocente create(AsignacionDocente asignacionDocente) {
        return repository.save(asignacionDocente);
    }

    @Override
    public AsignacionDocente update(AsignacionDocente asignacionDocente, Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception(
                    "Can't update AsignacionDocente with id: " + id + " because it does not exist");
        }
        asignacionDocente.setId(id);
        return repository.save(asignacionDocente);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public List<AsignacionDocente> findByActivaTrue() {
        return repository.findByActivaTrue();
    }

    @Override
    public List<AsignacionDocente> findByActivaFalse() {
        return repository.findByActivaFalse();
    }
}
