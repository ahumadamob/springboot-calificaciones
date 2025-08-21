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
    public Cursada create(Cursada cursada) {
    	return repo.save(cursada);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public Cursada update(Cursada cursada, Long id) throws Exception{
        if(repo.existsById(id)){
            cursada.setId(id);
            return repo.save(cursada);
        }else {
            throw new Exception("Cursada con ID " + id + " no encontrado.");
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
}