package com.auto.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") 
public class GestionAlta {

	@GetMapping("/hola")
	public String getAll(Model model) {
		return "index";
	}
	
	@GetMapping("/hola")
	public String getAll2(Model model) {
		return "index";
	}
	
	@GetMapping("/hola")
	public String getAll3(Model model) {
		return "index";
	}
	
	

}