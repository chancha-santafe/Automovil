package com.auto.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto.model.Variante;

public interface IVarianteRepo extends JpaRepository<Variante, Integer>{
	
	Variante findByNombre(String nombre);

}