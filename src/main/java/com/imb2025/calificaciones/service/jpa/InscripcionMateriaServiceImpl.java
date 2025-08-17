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
            throw new NoSuchElementException("No se encontró Inscripcion con el id " + id);
        }

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public InscripcionMateria fromDto(InscripcionMateriaRequestDto inscripcionMateriaDTO) throws Exception {
        InscripcionMateria inscripcionMateria = new InscripcionMateria();

        Alumno alumno = alumnoRepository.findById(inscripcionMateriaDTO.getIdAlumno())
                .orElseThrow(() -> new Exception(
                        "Alumno no encontrado con ID: " + inscripcionMateriaDTO.getIdAlumno()));
        inscripcionMateria.setAlumno(alumno);

        Materia materia = materiaRepository.findById(inscripcionMateriaDTO.getIdMateria())
                .orElseThrow(() -> new Exception(
                        "Materia no encontrada con ID: " + inscripcionMateriaDTO.getIdMateria()));
        inscripcionMateria.setMateria(materia);

        PeriodoLectivo periodoLectivo = periodoLectivoRepository.findById(inscripcionMateriaDTO.getIdPeriodoLectivo())
                .orElseThrow(() -> new Exception(
                        "Periodo Lectivo no encontrado con ID: " + inscripcionMateriaDTO.getIdPeriodoLectivo()));
        inscripcionMateria.setPeriodoLectivo(periodoLectivo);

        return inscripcionMateria;
    }

}
