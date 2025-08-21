package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.InscripcionMateriaRequestDto;
import com.imb2025.calificaciones.entity.InscripcionMateria;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.PeriodoLectivo;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.PeriodoLectivoRepository;
import com.imb2025.calificaciones.repository.InscripcionMateriaRepository;
import com.imb2025.calificaciones.service.IInscripcionMateriaService;

@Service
public class InscripcionMateriaServiceImpl implements IInscripcionMateriaService {

    @Autowired
    private InscripcionMateriaRepository repository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private PeriodoLectivoRepository periodoLectivoRepository;

    public List<InscripcionMateria> findAll() {
        return repository.findAll();
    }

    public InscripcionMateria findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public InscripcionMateria create(InscripcionMateria inscripcionMateria) {
        return repository.save(inscripcionMateria);
    }

    public InscripcionMateria update(InscripcionMateria inscripcionMateria, Long id) throws Exception {
        if (repository.existsById(id)) {
            inscripcionMateria.setId(id);
            return repository.save(inscripcionMateria);
        } else {
            throw new Exception("No se encontró Inscripcion con el id " + id);
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
    public InscripcionMateria fromDto(InscripcionMateriaRequestDto inscripcionMateriaDto) throws Exception {
        InscripcionMateria inscripcionMateria = new InscripcionMateria();

        Alumno alumno = alumnoRepository.findById(inscripcionMateriaDto.getAlumnoId())
                .orElseThrow(() -> new Exception(
                        "Alumno no encontrado con ID: " + inscripcionMateriaDto.getAlumnoId()));
        inscripcionMateria.setAlumno(alumno);

        Materia materia = materiaRepository.findById(inscripcionMateriaDto.getMateriaId())
                .orElseThrow(() -> new Exception(
                        "Materia no encontrada con ID: " + inscripcionMateriaDto.getMateriaId()));
        inscripcionMateria.setMateria(materia);

        PeriodoLectivo periodoLectivo = periodoLectivoRepository.findById(inscripcionMateriaDto.getPeriodoLectivoId())
                .orElseThrow(() -> new Exception(
                        "Periodo Lectivo no encontrado con ID: " + inscripcionMateriaDto.getPeriodoLectivoId()));
        inscripcionMateria.setPeriodoLectivo(periodoLectivo);

        return inscripcionMateria;
    }

}
