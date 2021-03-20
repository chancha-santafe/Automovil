package com.auto.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.auto.model.Variante;
import com.auto.repo.IVarianteRepo;
import com.auto.service.VarianteService;

public class VariantesServiceImpl implements VarianteService {

	@Autowired
	private IVarianteRepo varianteRepo;

	public List<Variante> findAll() {
		return varianteRepo.findAll();
	}

}