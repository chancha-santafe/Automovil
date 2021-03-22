package com.auto.service;

import java.util.List;

import com.auto.model.Automovil;

public interface AutoService {
	
	public List<Automovil> findAll();
	
	public Automovil save(String id, String nombre, List<String> lista);
	
	public Automovil findByNombre(String nombre);
	
	public void deleteByNombre(Automovil automovil);

}
