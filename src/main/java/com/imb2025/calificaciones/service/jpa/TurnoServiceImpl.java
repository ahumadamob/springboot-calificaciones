package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.TurnoRequestDto;
import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.repository.TurnoRepository;
import com.imb2025.calificaciones.service.ITurnoService;

@Service
public class TurnoServiceImpl implements ITurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno findById(Long id) {
        return turnoRepository.findById(id).orElseThrow(() -> new RuntimeException("Turno no encontrado"));
    }

    @Override
    public Turno create (Turno turno) {
        return turnoRepository.save(turno);

    }

    @Override
    public Turno update(Turno turno, Long id) throws Exception {
        if(turnoRepository.existsById(id)) {
            turno.setId(id);
            return turnoRepository.save(turno);
        }else {
            throw new Exception("No se encontro Turno con id: " + id);
        }
    }

    @Override
    public void deleteById(Long id) throws Exception  {
        if (turnoRepository.existsById(id)) {
            turnoRepository.deleteById(id);
        } else {
            throw new Exception("Turno no encontrado");
        }
    }

    @Override
    public Turno fromDto(TurnoRequestDto turnoRequestDto) {
        Turno turno = new Turno();
        turno.setNombre(turnoRequestDto.getNombre());
        turno.setHoraInicio(turnoRequestDto.getHoraInicio());
        turno.setHoraFin(turnoRequestDto.getHoraFin());
        return turno;
    }

}
