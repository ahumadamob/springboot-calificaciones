package com.imb2025.calificaciones.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.SedeRequestDto;
import com.imb2025.calificaciones.entity.Sede;
import com.imb2025.calificaciones.repository.SedeRepository;
import com.imb2025.calificaciones.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService {

    @Autowired
    private SedeRepository repo;

    @Override
    public List<Sede> findAll() {
        return repo.findAll();
    }

    @Override
    public Sede findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Sede create(Sede sede) {
        return repo.save(sede);
    }

    @Override
    public Sede update(Sede sede, Long id) throws Exception {
        if (repo.existsById(id)) {
            sede.setId(id);
            return repo.save(sede);
        } else {
            throw new Exception("Sede con ID " + id + " no encontrada.");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        repo.deleteById(id);
    }

    @Override
    public Sede fromDto(SedeRequestDto dto) throws Exception {
        if (dto == null) {
            throw new Exception("El dto de sede no puede ser nulo");
        }
        Sede sede = new Sede();
        sede.setNombre(dto.getNombre());
        sede.setDireccion(dto.getDireccion());
        return sede;
    }
}
