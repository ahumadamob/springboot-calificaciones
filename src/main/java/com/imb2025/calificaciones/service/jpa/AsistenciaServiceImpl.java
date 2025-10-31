package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.entity.Asistencia;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.AsistenciaRepository;
import com.imb2025.calificaciones.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Override
    public List<Asistencia> findAll() {
        return asistenciaRepository.findAll();
    }

    @Override
    public Asistencia findById(Long id) {
        return asistenciaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con id " + id));
    }

    @Override
    public Asistencia create(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public Asistencia update(Asistencia asistencia, Long id) throws Exception {
        if (!asistenciaRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró la asistencia con ID: " + id);
        }
        asistencia.setId(id);
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!asistenciaRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar el id: " + id + " porque no existe");
        }
        asistenciaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return asistenciaRepository.existsById(id);
    }

    @Override
    public long countByPresente(boolean presente) {
        return asistenciaRepository.countByPresente(presente);
    }

    @Override
    public List<Asistencia> findByAlumnoNombreIgnoreCase(String nombre) {
        return asistenciaRepository.findByAlumno_NombreIgnoreCase(nombre);
    }
}
