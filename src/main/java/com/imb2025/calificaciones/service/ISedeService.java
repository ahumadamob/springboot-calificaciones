package com.imb2025.calificaciones.service;

import java.util.List;

import com.imb2025.calificaciones.entity.Sede;

/* INTERFACE: "Sirve para definir como se tienen comportar todas las cosas. Ahora debemos darle 
 la Funcionalidad y lo hacemos a traves de una CLASE que va a IMPLEMENTAR esta INTERFACE.
 Las IMPLEMENTACIONES las vamos a colocar dentro del JPA:calificaciones.service.jpa".
 
 * findAll(Busca todos los registros en la DB)--> Devuelve listado de Sedes
 * findById(Busca los registros por Id)--> Devuelve Sede que encuentro
 * save(Guardar)(Le paso como parám todo un objeto del tipo Sede)--> Devuelve Sede que encuentro del tipo Sede sede
 * deletedById()-->Por ahora no devuelve nada "VOID"
 * */
public interface ISedeService {

	public List<Sede>findAll();
	public Sede findById(Long id);
	public Sede save(Sede sede);
	public void deletedById(Long id);
	
	
}
