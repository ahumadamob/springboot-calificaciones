package com.imb2025.calificaciones.service.jpa;

import com.imb2025.calificaciones.dto.RequisitoMateriaRequestDto;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.entity.RequisitoMateria;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.repository.RequisitoMateriaRepository;
import com.imb2025.calificaciones.service.IRequisitoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequisitoMateriaServiceImpl implements IRequisitoMateriaService {

    @Autowired
    private RequisitoMateriaRepository requisitoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<RequisitoMateria> findAll() {
        return requisitoRepository.findAll();
    }

    @Override
    public Optional<RequisitoMateria> findById(Long id) {
        return requisitoRepository.findById(id);
    }

    @Override
    public RequisitoMateria create(RequisitoMateriaRequestDto dto) {
        try {
            RequisitoMateria requisito = fromDto(dto);
            return requisitoRepository.save(requisito);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar requisito: " + e.getMessage());
        }
    }

    @Override
    public RequisitoMateria update(RequisitoMateriaRequestDto dto, Long id) throws Exception {
        try {
            RequisitoMateria existente = requisitoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Requisito con ID " + id + " no encontrado."));

            RequisitoMateria actualizado = fromDto(dto);
            existente.setMateria(actualizado.getMateria());
            existente.setMateriaCorrelativa(actualizado.getMateriaCorrelativa());

            return requisitoRepository.save(existente);
        } catch (EntidadNoEncontradaException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error al actualizar requisito: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!requisitoRepository.existsById(id)) {
            throw new Exception("No se puede eliminar el id: " + id + " porque no existe");
        }
        requisitoRepository.deleteById(id);
    }

    @Override
    public RequisitoMateria fromDto(RequisitoMateriaRequestDto dto) throws Exception {
        Materia materia = materiaRepository.findById(dto.getMateriaId())
                .orElseThrow(() -> new Exception("Materia con ID " + dto.getMateriaId() + " no encontrada."));
        Materia correlativa = materiaRepository.findById(dto.getMateriaRequeridaId())
                .orElseThrow(() -> new Exception("Materia correlativa con ID " + dto.getMateriaRequeridaId() + " no encontrada."));
        RequisitoMateria entidad = new RequisitoMateria();
        entidad.setMateria(materia);
        entidad.setMateriaCorrelativa(correlativa);
        return entidad;
    }
}
