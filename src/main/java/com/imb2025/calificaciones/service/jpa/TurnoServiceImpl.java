package com.imb2025.calificaciones.service.jpa;

import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.request.TurnoRequestDto;
import com.imb2025.calificaciones.entity.Turno;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.TurnoRepository;
import com.imb2025.calificaciones.service.ITurnoService;

@Service
public class TurnoServiceImpl implements ITurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno findById(Long id) {
        return turnoRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException(
                "Entidad no encontrada con id " + id));
    }

    @Override
    public Turno create (Turno turno) {
        return turnoRepository.save(turno);

    }

    @Override
    public Turno update(Turno turno, Long id) throws Exception {
        if(turnoRepository.existsById(id)) {
            turno.setId(id);
            return turnoRepository.save(turno);
        }else {
            throw new ResourceNotFoundException("No se encontro Turno con id: " + id);
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (!turnoRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar el id: " + id + " porque no existe");
        }
        turnoRepository.deleteById(id);
    }

   

	@Override
	public List<Turno> mostrarTurnosPorNombre(String nombre) {
		
		return turnoRepository.findByNombre(nombre);
	}

	@Override
	public Long contarTurnosQueTerminanDespuesDe(LocalTime hora) {
		
		return turnoRepository.countByHoraFinAfter(hora);
	}
	
	 @Override
	    public List<Turno> listarActivos() {
	        return turnoRepository.findByActivoTrue();
	    }

	 @Override
	    public List<Turno> listarInactivos() {
	        return turnoRepository.findByActivoFalse();
	    }
	

}
