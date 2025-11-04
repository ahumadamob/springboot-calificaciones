
package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.mapper.DocenteMapper;
import com.imb2025.calificaciones.dto.request.DocenteRequestDto;
import com.imb2025.calificaciones.dto.response.DocenteResponseDto;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.service.IDocenteService;

@Service
public class DocenteServiceImpl implements IDocenteService {

    @Autowired
    private DocenteRepository repo;

    @Autowired
    private DocenteMapper mapper;

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
    public DocenteResponseDto create(DocenteRequestDto docenteDTO) {
        Docente docente = mapper.fromDto(docenteDTO);
        Docente saved = repo.save(docente);
        return mapper.toResponseDto(saved);
    }

    @Override
    public DocenteResponseDto update(Long id, DocenteRequestDto docenteDTO) throws Exception {
        if (id == null || !repo.existsById(id)) {
            throw new Exception("Docente con ID " + id + " no encontrado.");
        }
        Docente docente = mapper.fromDto(docenteDTO);
        docente.setId(id);
        Docente updated = repo.save(docente);
        return mapper.toResponseDto(updated);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (id == null || !repo.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    @Override
    public List<Docente> findByApellido(String apellido) {
        return repo.findByApellido(apellido);
    }

    @Override
    public Long countByTitulo(String titulo) {
        return repo.countByTitulo(titulo);
    }

}
