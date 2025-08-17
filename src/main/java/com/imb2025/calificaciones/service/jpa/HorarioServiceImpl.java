package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Horario;
import com.imb2025.calificaciones.repository.HorarioRepository;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.service.IHorarioService;

@Service
public class HorarioServiceImpl implements IHorarioService{

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private ComisionRepository comisionRepository;

    @Override
    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    @Override
    public Horario create(Horario nuevoHorario) {
        return horarioRepository.save(nuevoHorario);
    }

    @Override
    public Horario update(Horario datosActualizados, Long id) {
        return horarioRepository.save(datosActualizados);
    }

    @Override
    public void deleteById(Long id) {
        horarioRepository.deleteById(id);
    }

    @Override
    public Horario findById(Long id) {
        return horarioRepository.findById(id).orElse(null);
    }

    @Override
    public Horario fromDto(HorarioRequestDto dto) throws Exception {
        Horario horario = new Horario();
        if (dto.getComisionId() != null) {
            horario.setComision(comisionRepository.findById(dto.getComisionId())
                    .orElseThrow(() -> new Exception("Comision no encontrada con id: " + dto.getComisionId())));
        }
        horario.setDiaSemana(dto.getDiaSemana());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());
        return horario;
    }
}
