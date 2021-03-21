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
@PrimaryKeyJoinColumn(name = "ID")
public class Automovil {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "COSTO")
	private Double costo;
	
	@Column (name= "VARIANTE")
	@OneToMany
	private List<Variante> variantes;

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

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public List<Variante> getVariantes() {
		return variantes;
	}

	public void setVariantes(List<Variante> variantes) {
		this.variantes = variantes;
	}

}
