package com.auto.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.auto.model.Automovil;
import com.auto.repo.IAutoRepo;
import com.auto.service.AutoService;

public class AutoServiceImpl implements AutoService{
	
	@Autowired
	private IAutoRepo autoRepo; 

	public List<Automovil> findAll() {
		return autoRepo.findAll();
	}
	
	

}
