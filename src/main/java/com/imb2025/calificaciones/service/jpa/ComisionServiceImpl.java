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
    public Comision update(Comision comision, Long id) {
        comision.setId(id);
        return repository.save(comision);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Comision fromDto(ComisionRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Turno turno = turnoRepository.findById(dto.getTurnoId()).orElse(null);
        Sede sede = sedeRepository.findById(dto.getSedeId()).orElse(null);
        return new Comision(dto.getNombre(), turno, sede);
    }
}
