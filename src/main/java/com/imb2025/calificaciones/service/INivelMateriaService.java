package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.NivelMateria;

public interface INivelMateriaService {
	
	public List<NivelMateria> findAll ();
	
	 public NivelMateria finById(Long id);
	 
	 public NivelMateria save(NivelMateria nivelMateria);
	 
	 public void deleteById(Long id);


}
