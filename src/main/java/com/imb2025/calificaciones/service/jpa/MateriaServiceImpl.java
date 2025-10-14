package com.imb2025.calificaciones.service.jpa;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.MateriaRequestDto;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.exception.ResourceNotFoundException;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.service.IMateriaService;
import com.imb2025.calificaciones.exception.EntidadNoEncontradaException;

@Service
public class MateriaServiceImpl implements IMateriaService{

    @Autowired
    private MateriaRepository repo;

    @Override
    public List<Materia> findAll() {

        return repo.findAll();

    }

    @Override
    public Materia findById(Long id) {

        
        return repo.findById(id)
        	    .orElseThrow(() -> new ResourceNotFoundException(
        	        "Materia no encontrada con id " + id));
    }

    @Override
    public Materia create (Materia materia) {

        return repo.save(materia);
    }

    @Override
    public Materia update(Materia materia, Long id) throws Exception {
        if(repo.existsById(id)) {
            materia.setId(id);
            return repo.save(materia);
        }else {
            throw new Exception("No se encontró materia con id" + id);
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
    public Materia fromDto(MateriaRequestDto materiaRequestDto) throws Exception {
        Materia materia = new Materia();
        materia.setNombre(materiaRequestDto.getNombre());
        materia.setCargaHoraria(materiaRequestDto.getCargaHoraria());
        materia.setCodigo(materiaRequestDto.getCodigo());
        materia.setNivel(materiaRequestDto.getNivel());

        return materia;
    }

	@Override
	public List<Materia> findAllOrder() {
		
		return repo.findByOrderByNombreAsc();
	}

	@Override
	public List<Materia> findByNivelEndsWith(String sufijo) {
		return repo.findByNivelEndingWithIgnoreCase(sufijo);
	}

	@Override
	public Materia findByCodigo(String codigo) {
		return repo.findByCodigo(codigo)
        	    .orElseThrow(() -> new EntidadNoEncontradaException(
        	        "Materia no encontrada con codigo " + codigo));
	}

	@Override
	public long findByCargaHoraria(Integer cargaHoraria) {
		
		return repo.countByCargaHoraria(cargaHoraria);
	}

	
}
