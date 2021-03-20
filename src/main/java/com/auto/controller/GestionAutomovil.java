package com.auto.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.model.Automovil;
import com.auto.service.AutoService;

@RestController
@RequestMapping("/api") 
public class GestionAutomovil{
		
	@Autowired
	private AutoService autoservice;

	@GetMapping("/hola")
	public String getAll(Model model) {
		List<Automovil>  list= autoservice.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		return "index";
	}
	

}