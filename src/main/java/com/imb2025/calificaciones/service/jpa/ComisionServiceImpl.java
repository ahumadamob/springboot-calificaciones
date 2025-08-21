package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.ComisionRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Sede;
import com.imb2025.calificaciones.entity.Turno;
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
    private ComisionRepository repository;

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public List<Comision> findAll() {
        return repository.findAll();
    }

    @Override
    public Comision findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Comision create(Comision comision) {
        return repository.save(comision);
    }

    @Override
    public Comision update(Comision comision, Long id) throws Exception {
        if (repository.existsById(id)) {
            comision.setId(id);
            return repository.save(comision);
        } else {
            throw new Exception("Comision con ID " + id + " no encontrada");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public Comision fromDto(ComisionRequestDto dto) throws Exception {
        if (dto == null) {
            return null;
        }
        Turno turno = turnoRepository.findById(dto.getTurnoId())
                .orElseThrow(() -> new Exception("Turno no encontrado con id: " + dto.getTurnoId()));
        Sede sede = sedeRepository.findById(dto.getSedeId())
                .orElseThrow(() -> new Exception("Sede no encontrada con id: " + dto.getSedeId()));
        return new Comision(dto.getNombre(), turno, sede);
    }
}
