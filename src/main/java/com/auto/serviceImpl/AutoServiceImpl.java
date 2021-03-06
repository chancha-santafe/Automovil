package com.auto.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.model.Automovil;
import com.auto.model.Variante;
import com.auto.repo.IAutoRepo;
import com.auto.repo.IVarianteRepo;
import com.auto.service.AutoService;

@Service
public class AutoServiceImpl implements AutoService {

	@Autowired
	private IAutoRepo iAutoRepo;

	@Autowired
	private IVarianteRepo iVarianteRepo;

	public List<Automovil> findAll() {
		return iAutoRepo.findAll();
	}

	/*
	 * Metodo que guarda un automovil y calcula su costo.
	 */
	public Automovil save(String id, String nombre, List<String> lista) {

		// Si ya se guardo un auto con ese id
		Automovil auto = new Automovil();
		auto = iAutoRepo.findByNombre(nombre);
		if (auto != null) {
			return null;
		} else {
			auto = new Automovil();
		}
		auto.setId(Integer.parseInt(id));
		auto.setNombre(nombre);
		Double costoTotal = Double.valueOf(0);
		List<Variante> listaVarinates = new ArrayList<>();

		// Buscamos el costo del auto basico
		Variante varianteAuto = iVarianteRepo.findByNombre(nombre);
		if (varianteAuto == null) {
			return null;
		} else {
			listaVarinates.add(varianteAuto);
			costoTotal += varianteAuto.getCosto();
		}

		// Buscamos uno a uno las variantes con sus costos
		for (int i = 0; i < lista.size(); i++) {
			Variante variante = iVarianteRepo.findByNombre(lista.get(i));
			if (variante != null) {
				costoTotal += variante.getCosto();
				listaVarinates.add(variante);
			}
		}
		auto.setCosto(costoTotal);
		auto.setVariantes(listaVarinates);
		return iAutoRepo.save(auto);

	}
	
	/*
	 * Metodo que actualiza un automovil y calcula su costo.
	 */
	public Automovil update(String id, String nombre, List<String> lista) {
		
		
		// Si ya se guardo un auto con ese id
		Automovil auto = iAutoRepo.findByNombre(nombre);
		
		auto.setId(Integer.parseInt(id));
		auto.setNombre(nombre);
		
		Double costoTotal = Double.valueOf(0);
		List<Variante> listaVarinates = new ArrayList<>();

		// Buscamos el costo del auto basico
		Variante varianteAuto = iVarianteRepo.findByNombre(nombre);
		listaVarinates.add(varianteAuto);
		costoTotal += varianteAuto.getCosto();


		// Buscamos uno a uno las variantes con sus costos
		for (int i = 0; i < lista.size(); i++) {
			Variante variante = iVarianteRepo.findByNombre(lista.get(i));
			if (variante != null) {
				costoTotal += variante.getCosto();
				listaVarinates.add(variante);
			}
		}
		auto.setCosto(costoTotal);
		auto.setVariantes(listaVarinates);
		return iAutoRepo.save(auto);

	}

	public Automovil findByNombre(String nombre) {
		return iAutoRepo.findByNombre(nombre);
	}

	public void deleteByNombre(Automovil automovil) {
		iAutoRepo.delete(automovil);
	}

}