package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.ComisionRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.SedeRepository;
import com.imb2025.calificaciones.repository.TurnoRepository;
import com.imb2025.calificaciones.service.IComisionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComisionServiceImpl implements IComisionService {

    @Autowired
    private ComisionRepository repo;

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public List<Comision> findAll() {
        return repo.findAll();
    }

    @Override
    public Comision findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comision no encontrada con id " + id));
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    @Override
    public Comision create(Comision comision) {
        return repo.save(comision);
    }

    @Override
    public Comision update(Comision comision, Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Comision con id " + id + " no existe");
        }
        comision.setId(id);
        return repo.save(comision);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar el id: " + id + " porque no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public Comision fromDto(ComisionRequestDto dto) throws Exception {
        if (dto == null) {
            throw new IllegalArgumentException("DTO no puede ser nulo");
        }
        Comision c = new Comision();
        c.setNombre(dto.getNombre());
        if (dto.getTurnoId() != null) {
            c.setTurno(turnoRepository.findById(dto.getTurnoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Turno con id " + dto.getTurnoId() + " no encontrado")));
        }
        if (dto.getSedeId() != null) {
            c.setSede(sedeRepository.findById(dto.getSedeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Sede con id " + dto.getSedeId() + " no encontrada")));
        }
        return c;
    }

    @Override
    public List<Comision> findByNombreContainingIgnoreCase(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public long countBySedeId(Long sedeId) {
        return repo.countBySedeId(sedeId);
    }
}
