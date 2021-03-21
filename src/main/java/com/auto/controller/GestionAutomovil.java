package com.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auto.model.Automovil;
import com.auto.model.Variante;
import com.auto.service.VarianteService;

@RestController
@RequestMapping(path = "/api")
//, consumes = "application/json", produces = "application/json"
public class GestionAutomovil {

	@Autowired
	private VarianteService varianteService;

	/**
	 * 
	 * Metodo GET que nos devuelve todos las variantes cargadas en la Tabla Parametrica "Variante"
	 */
	@GetMapping("/listVariantes")
	public List<Variante> getAllVariantes() {
		List<Variante> list = varianteService.findAll();
		return list;
	}
	
	/**
	 * 
	 * Metodo GET que nos devuelve los detalles de una variante a partir de su nombre
	 */
	@GetMapping("/variante")
	public ResponseEntity<Variante> getVariante(@RequestParam String nombre) {
		Variante variante = varianteService.findByNombre(nombre);
		if (variante == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(variante);
		}
	}
	
	
	
	
	

	// Recibe
	@GetMapping(path = "/variante2")
	public ResponseEntity<Variante> get(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("opcionales") List<String> opcionales) {
		Variante variante = varianteService.findByNombre(nombre);
		System.out.println(variante);
		System.out.println(id);
		System.out.println(nombre);
		System.out.println(opcionales);
		if (variante == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(variante);
		}
	}


	@GetMapping("/foos")
	@ResponseBody
	public String getFoos(@RequestParam List<String> id) {
		return "IDs are " + id;
	}

	// Recibe un JSON
	@PostMapping(path = "/libros", consumes = "application/json")
	public ResponseEntity<String> insertarLibro(@RequestBody Automovil a) {
		System.out.println("----" + a.getNombre());
		return new ResponseEntity(HttpStatus.OK);
	}

}