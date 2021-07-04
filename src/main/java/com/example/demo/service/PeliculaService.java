package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PeliculaDTO;
import com.example.demo.model.Pelicula;
import com.example.demo.repository.PeliculaRepository;

@Service
public class PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;

	public List<Pelicula> list() {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculaRepository.findAll().forEach(peliculas::add);
		return peliculas;
	}

	public Optional<Pelicula> getById(long id) {
		return peliculaRepository.findById(id);
	}

	public void save(PeliculaDTO peliculaDTO) {
		Pelicula pelicula = new Pelicula(peliculaDTO.getNombre(), peliculaDTO.getGenero(), peliculaDTO.getDirector());
		peliculaRepository.save(pelicula);
	}

	public boolean update(long id, PeliculaDTO pelicula) {
		Optional<Pelicula> peliculaData = peliculaRepository.findById(id);
		if (peliculaData.isPresent()) {
			Pelicula peliculaActualizar = peliculaData.get();
			if (peliculaActualizar.getNombre().equals(pelicula.getNombre()))
				peliculaActualizar.setDirector(pelicula.getDirector());
			if (peliculaActualizar.getGenero().equals(pelicula.getGenero()))
				peliculaActualizar.setGenero(pelicula.getGenero());
			if (peliculaActualizar.getDirector().equals(pelicula.getDirector()))
				peliculaActualizar.setNombre(pelicula.getDirector());
			peliculaRepository.save(peliculaActualizar);
			return true;
		} else {
			return false;
		}
	}

	public void delete(long id) {
		peliculaRepository.deleteById(id);
	}

}
