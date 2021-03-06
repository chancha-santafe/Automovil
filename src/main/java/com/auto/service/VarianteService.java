package com.auto.service;

import java.util.List;

import com.auto.model.Variante;

public interface VarianteService {
	
	public List<Variante> findAll();
	
	public Variante findByNombre(String nombre);
	
	public Variante save(Variante variante);
	
	public Variante save(String id, String nombre, String costo, String descricpcion );

}
