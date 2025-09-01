package com.imb2025.calificaciones.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.DocenteRequestDto;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.service.IDocenteService;

@Service
public class DocenteServiceImpl implements IDocenteService {

    @Autowired
    private DocenteRepository repo;

    @Override
    public List<Docente> findAll() {
        return repo.findAll();

    }

    @Override
    public Docente findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente con id " + id + " no encontrado"));
    }

    @Override
    public Docente fromDto(DocenteRequestDto docenteDTO) throws Exception {

        Docente docente = new Docente();
        docente.setNombre(docenteDTO.getNombre());
        docente.setApellido(docenteDTO.getApellido());
        docente.setEmail(docenteDTO.getEmail());
        docente.setLegajo(docenteDTO.getLegajo());
        docente.setTitulo(docenteDTO.getTitulo());

        return docente;

    }

    @Override
    public Docente create(Docente docente) {

        return repo.save(docente);

    }

    @Override
    public Docente update(Docente docente, Long id) throws Exception {

        if (repo.existsById(id)) {
            docente.setId(id);
            return repo.save(docente);
        } else {
            throw new Exception("Docente con ID " + id + " no encontrado.");
        }

    }

    public void deleteById(Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public ResponseEntity<Docente> existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

}