package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.Comision;

public interface IComisionService {

	   public List<Comision> findAll();
	   
	   public Comision findById(Long id);
	    
	   public Comision save(Comision Comision);
	   
	   Comision update(Long id, Comision Comision);
	   
	   public void deleteById(Long id);
}
