package com.auto.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.model.Variante;
import com.auto.repo.IVarianteRepo;
import com.auto.service.VarianteService;

@Service
public class VariantesServiceImpl implements VarianteService {

	@Autowired
	private IVarianteRepo varianteRepo;

	public List<Variante> findAll() {
		return varianteRepo.findAll();
	}
	
	public Variante findByNombre(String nombre){
		return varianteRepo.findByNombre(nombre);
	}


}