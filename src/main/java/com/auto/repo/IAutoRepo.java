package com.auto.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto.model.Automovil;

public interface IAutoRepo extends JpaRepository<Automovil, Integer>{

}