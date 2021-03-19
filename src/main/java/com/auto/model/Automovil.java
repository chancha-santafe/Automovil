package com.auto.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOMOVIL")
@PrimaryKeyJoinColumn (name = "ID")
public class Automovil {

	@Id
	@Column (name = "ID")
	private int id;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "AUTOMOVIL")
	private List<Caracteristica> list ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Caracteristica> getList() {
		return list;
	}

	public void setList(List<Caracteristica> list) {
		this.list = list;
	}
	
}