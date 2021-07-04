package com.example.demo.dto;


public class PeliculaDTO {

	private String nombre;

	private String genero;

	private String director;

	public PeliculaDTO() {
		super();
	}
	
	public PeliculaDTO(String nombre, String genero, String director) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.director = director;
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
