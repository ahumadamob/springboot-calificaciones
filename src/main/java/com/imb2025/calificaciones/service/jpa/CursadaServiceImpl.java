package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.CursadaRequestDto;
import com.imb2025.calificaciones.entity.Alumno;
import com.imb2025.calificaciones.entity.CondicionFinal;
import com.imb2025.calificaciones.entity.Cursada;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.repository.AlumnoRepository;
import com.imb2025.calificaciones.repository.CondicionFinalRepository;
import com.imb2025.calificaciones.repository.CursadaRepository;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.service.ICursadaService;
@Service
public class CursadaServiceImpl implements ICursadaService{

    @Autowired
    CursadaRepository repo;
    @Autowired
    AlumnoRepository alumnorepo;
    @Autowired
    MateriaRepository materiaRepository;
    @Autowired
    CondicionFinalRepository cRepository;

    @Override
    public List<Cursada> findAll() {
        return repo.findAll();
    }

    @Override
    public Cursada findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String create(CursadaRequestDto dto) {
         Cursada cursada = new Cursada();
        Mapper(cursada, dto);
        return "Guardado correctamente";
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public String update(CursadaRequestDto dto, Long id){
         Cursada cursada = repo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cursada no encontrada"));
        Mapper(cursada, dto);
        return"Updateada correctamente";
    }

    public void Mapper(Cursada cursada, CursadaRequestDto dto){

                Alumno alumno = alumnorepo.findById(dto.getAlumnoId())
                    .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

                Materia materia = materiaRepository.findById(dto.getMateriaId())
                    .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

                CondicionFinal condicionFinal = cRepository.findById(dto.getCondicionFinalId())
                    .orElseThrow(() -> new RuntimeException("Condición final no encontrada"));

                cursada.setAlumno(alumno);
                cursada.setMateria(materia);
                cursada.setCondicionFinal(condicionFinal);
                repo.save(cursada);

            }

    }

    @Override
    public Cursada fromDto(CursadaRequestDto dto) throws Exception {
        Cursada cursada = new Cursada();
        Alumno alumno = alumnorepo.findById(dto.getAlumnoId())
                .orElseThrow(() -> new Exception("Alumno no encontrado con id: " + dto.getAlumnoId()));
        Materia materia = materiaRepository.findById(dto.getMateriaId())
                .orElseThrow(() -> new Exception("Materia no encontrada con id: " + dto.getMateriaId()));
        CondicionFinal condicionFinal = cRepository.findById(dto.getCondicionFinalId())
                .orElseThrow(() -> new Exception("Condición final no encontrada con id: " + dto.getCondicionFinalId()));
        cursada.setAlumno(alumno);
        cursada.setMateria(materia);
        cursada.setCondicionFinal(condicionFinal);
        return cursada;
    }
