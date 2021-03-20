package com.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.model.Variante;
import com.auto.service.AutoService;
import com.auto.service.VarianteService;

@RestController
@RequestMapping("/api") 
public class GestionAutomovil{
		
	@Autowired
	private AutoService autoservice;
	
	@Autowired
	private VarianteService varianteService;

	@GetMapping("/hola")
	public String getAll(Model model) {
		List<Variante>  list= varianteService.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		return "index";
	}
	

}