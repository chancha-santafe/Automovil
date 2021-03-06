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

	public Variante findByNombre(String nombre) {
		return varianteRepo.findByNombre(nombre);
	}

	public Variante save(Variante variante) {
		Variante var = varianteRepo.save(variante);
		if (var != null) {
			return var;
		} else {
			return null;
		}
	}
	
	public Variante save(String id, String nombre, String costo, String descricpcion ) {
		Variante variante = new Variante();
		variante.setCosto(Double.valueOf(costo));
		variante.setNombre(nombre);
		variante.setDescripcion(descricpcion);
		variante.setId(Integer.valueOf(id));
		return varianteRepo.save(variante);
	}

}