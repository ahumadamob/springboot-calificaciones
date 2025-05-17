package com.imb2025.calificaciones.service;

import java.util.List;


import com.imb2025.calificaciones.entity.Cursada;

public interface ICursadaService {
	
	public List<Cursada> findAll();
	public Cursada findById(Long id);
	public Cursada save(Cursada cursada);
	public void deleteById (Long id);
	

}
