package com.imb2025.calificaciones.service.jpa;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.entity.Cursada;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.CursadaRepository;
import com.imb2025.calificaciones.service.ICursadaService;

@Service
public class CursadaServiceImpl implements ICursadaService {

    @Autowired
    private CursadaRepository repo;

    
    @Override
    public List<Cursada> findAll() {
        return repo.findAll();
    }

    @Override
    public Cursada findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cursada no encontrada con id " + id));
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
    public Cursada update(Cursada cursada, Long id) throws Exception {
        if (repo.existsById(id)) {
            cursada.setId(id);
            return repo.save(cursada);
        } else {
            throw new Exception("Cursada con ID " + id + " no encontrado.");
        }
    }

   

    @Override
    public List<Cursada> findByNombreAlumno(String nombre) {
        return repo.findByAlumno_Nombre(nombre);
    }

    @Override
    public Long countByNombreMateria(String nombreMateria) {
        return repo.countByMateria_Nombre(nombreMateria);
    }
}
