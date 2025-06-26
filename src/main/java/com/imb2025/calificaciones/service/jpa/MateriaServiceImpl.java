package com.imb2025.calificaciones.service.jpa;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb2025.calificaciones.dto.MateriaRequestDTO;
import com.imb2025.calificaciones.entity.Materia;
import com.imb2025.calificaciones.repository.MateriaRepository;
import com.imb2025.calificaciones.service.IMateriaService;


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
	
		
		
		return repo.findById(id).orElse(null);
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
	public void deleteById(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Materia mapFromDto(MateriaRequestDTO materiaRequestDto) throws Exception {
		Materia materia = new Materia();
		materia.setNombre(materiaRequestDto.getNombre());
		materia.setCargaHoraria(materiaRequestDto.getCargaHoraria());
		materia.setCodigo(materiaRequestDto.getCodigo());
		materia.setNivel(materiaRequestDto.getNivel());
		
		return materia;
	}
}
