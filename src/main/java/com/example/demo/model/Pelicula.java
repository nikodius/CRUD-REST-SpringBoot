package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "genero")
	private String genero;

	@Column(name = "director")
	private String director;

	public Pelicula() {
		super();
	}

	public Pelicula(long id, String nombre, String genero, String director) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.director = director;
	}
	
	public Pelicula(String nombre, String genero, String director) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.director = director;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}
