package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.Comisión;

public interface IComisiónService {

	   public List<Comisión> findAll();
	   
	   public Comisión findById(Long id);
	    
	   public Comisión save(Comisión Comisión);
	   
	   Comisión update(Long id, Comisión Comisión);
	   
	   public void deleteById(Long id);
}
