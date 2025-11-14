package com.imb2025.calificaciones.service.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.request.RegistroClaseRequestDto;
import com.imb2025.calificaciones.entity.Comision;
import com.imb2025.calificaciones.entity.Docente;
import com.imb2025.calificaciones.entity.RegistroClase;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.ComisionRepository;
import com.imb2025.calificaciones.repository.DocenteRepository;
import com.imb2025.calificaciones.repository.RegistroClaseRepository;
import com.imb2025.calificaciones.service.IRegistroClaseService;

@Service
public class RegistroClaseServiceImpl implements IRegistroClaseService {

    private final RegistroClaseRepository registroClaseRepository;
    private final DocenteRepository docenteRepository;
    private final ComisionRepository comisionRepository;

    public RegistroClaseServiceImpl(RegistroClaseRepository registroClaseRepository,
                                    DocenteRepository docenteRepository,
                                    ComisionRepository comisionRepository) {
        this.registroClaseRepository = registroClaseRepository;
        this.docenteRepository = docenteRepository;
        this.comisionRepository = comisionRepository;
    }

    @Override
    public List<RegistroClase> findAll() {
        return registroClaseRepository.findAll();
    }

    @Override
    public List<RegistroClase> findByTema(String tema) {
        return registroClaseRepository.findByTemaContainingIgnoreCase(tema);
    }

    @Override
    public Long countByFecha(LocalDate fecha) {
        return registroClaseRepository.countByFecha(fecha);
    }

    @Override
    public RegistroClase findById(Long id) {
        return registroClaseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("RegistroClase no encontrado con id: " + id));
    }

    @Override
    public RegistroClase create(RegistroClase registroClase) {
        return registroClaseRepository.save(registroClase);
    }

    @Override
    public void deleteById(Long id) {
        if (!registroClaseRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. RegistroClase no encontrado con id: " + id);
        }
        registroClaseRepository.deleteById(id);
    }

    @Override
    public RegistroClase update(RegistroClase data, Long id) {
        RegistroClase existente = findById(id);

        existente.setFecha(data.getFecha());
        existente.setTema(data.getTema());
        existente.setDocente(data.getDocente());
        existente.setComision(data.getComision());

        return registroClaseRepository.save(existente);
    }

    @Override
    public RegistroClase fromDto(RegistroClaseRequestDto dto) {
        Docente docente = docenteRepository.findById(dto.getDocenteId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Docente no encontrado con id: " + dto.getDocenteId()));

        Comision comision = comisionRepository.findById(dto.getComisionId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Comisión no encontrada con id: " + dto.getComisionId()));

        RegistroClase registro = new RegistroClase();
        registro.setFecha(dto.getFecha());
        registro.setTema(dto.getTema());
        registro.setDocente(docente);
        registro.setComision(comision);

        return registro;
    }

   
    public RegistroClase createFromDto(RegistroClaseRequestDto dto) {
        RegistroClase registro = fromDto(dto);
        return registroClaseRepository.save(registro);
    }

    public RegistroClase updateFromDto(Long id, RegistroClaseRequestDto dto) {
        RegistroClase existente = findById(id);

        Docente docente = docenteRepository.findById(dto.getDocenteId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Docente no encontrado con id: " + dto.getDocenteId()));

        Comision comision = comisionRepository.findById(dto.getComisionId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Comisión no encontrada con id: " + dto.getComisionId()));

        existente.setFecha(dto.getFecha());
        existente.setTema(dto.getTema());
        existente.setDocente(docente);
        existente.setComision(comision);

        return registroClaseRepository.save(existente);
    }
}
