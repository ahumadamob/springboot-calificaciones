package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.AsignacionDocenteRequestDto;
import com.imb2025.calificaciones.entity.AsignacionDocente;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.repository.AsignacionDocenteRepository;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.PeriodoLectivoRepository;
import com.imb2025.calificaciones.service.IAsignacionDocenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionDocenteServiceImpl implements IAsignacionDocenteService {

    @Autowired
    private AsignacionDocenteRepository repository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private ComisionRepository comisionRepository;

    @Autowired
    private PeriodoLectivoRepository periodoLectivoRepository;

    @Override
    public List<AsignacionDocente> findAll() {
        return repository.findAll();
    }

    @Override
    public AsignacionDocente findById(Long id) {
        return repository.findById(id).orElse(null);
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
            throw new Exception(
                    "Can't delete AsignacionDocente with id: " + id + " because it does not exist");
        }
        repository.deleteById(id);
    }

    @Override
    public AsignacionDocente fromDto(AsignacionDocenteRequestDto dto) throws Exception {
        Docente docente = docenteRepository.findById(dto.getDocenteId())
                .orElseThrow(() -> new Exception("Docente no encontrado con id: " + dto.getDocenteId()));
        Materia materia = materiaRepository.findById(dto.getMateriaId())
                .orElseThrow(() -> new Exception("Materia no encontrada con id: " + dto.getMateriaId()));
        Comision comision = comisionRepository.findById(dto.getComisionId())
                .orElseThrow(() -> new Exception("Comision no encontrada con id: " + dto.getComisionId()));
        PeriodoLectivo periodoLectivo = periodoLectivoRepository.findById(dto.getPeriodoLectivoId())
                .orElseThrow(() -> new Exception("Periodo lectivo no encontrado con id: " + dto.getPeriodoLectivoId()));
        return new AsignacionDocente(docente, materia, comision, periodoLectivo);
    }
}
