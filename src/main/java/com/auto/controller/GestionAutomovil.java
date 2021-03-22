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
import com.auto.service.AutoService;
import com.auto.service.VarianteService;

@RestController
@RequestMapping(path = "/api")
public class GestionAutomovil {

	@Autowired
	private VarianteService varianteService;
	
	@Autowired
	private AutoService autoService;

	/**
	 * 
	 * Metodo GET que nos devuelve todos las variantes cargadas en la Tabla
	 * Parametrica "Variante"
	 */
	@GetMapping("/listVariantes")
	public List<Variante> getAllVariantes() {
		List<Variante> list = varianteService.findAll();
		return list;
	}

	/**
	 * 
	 * Metodo GET que nos devuelve los detalles de una variante a partir de su
	 * nombre
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

	/**
	 * 
	 * Metodo POST que inserta una variante nueva
	 */
	@PostMapping("/addVariante")
	public ResponseEntity<String> inseratrVariante(@RequestBody Variante var) {
		Variante variante = varianteService.save(var);
		if (variante == null) {
			return ResponseEntity.notFound().build();
		} else {
			return new ResponseEntity(HttpStatus.OK);
		}
	}
	

	/**
	 * 
	 * Metodo Post que guarda un nuevo Automovil en la Base de datos
	 * 
	 * @param id
	 * @param nombre
	 * @param opcionales
	 * @return Automovil
	 */
	
	@PostMapping(path = "/guardarAuto")
	public ResponseEntity<Automovil> get(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("opcionales") List<String> opcionales) {
		Automovil auto = autoService.save(id, nombre, opcionales);
		if (auto == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(auto);
		}
	}
	
	/**
	 * 
	 * Metodo GET que nos devuelve los detalles de un auto a partir de su
	 * nombre
	 */
	@GetMapping("/consultarAuto")
	public ResponseEntity<Automovil> getAuto(@RequestParam String nombre) {
		Automovil automovil = autoService.findByNombre(nombre);
		if (automovil == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(automovil);
		}
	}
	
	
	
	
	
	
	@GetMapping("/foos")
	@ResponseBody
	public String getFoos(@RequestParam List<String> id) {
		return "IDs are " + id;
	}

	// Recibe un JSON
	@PostMapping(path = "/libros")
	public ResponseEntity<String> insertarLibro(@RequestBody Automovil a, @RequestParam("opcionales") List<String> opcionales) {
		System.out.println("----" + a.getNombre());
		return new ResponseEntity(HttpStatus.OK);
	}

}