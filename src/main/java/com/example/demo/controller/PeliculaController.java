package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PeliculaDTO;
import com.example.demo.model.Pelicula;
import com.example.demo.service.PeliculaService;

@RestController
public class PeliculaController {

	@Autowired
	PeliculaService peliculaService;

	@GetMapping("/peliculas")
	public ResponseEntity<List<Pelicula>> getAll() {
		try {
			List<Pelicula> peliculas = new ArrayList<Pelicula>();
			peliculas = peliculaService.list();
			if (peliculas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(peliculas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/peliculas/{id}")
	public ResponseEntity<Pelicula> getPeliculaById(@PathVariable("id") long id) {
		try {
			Optional<Pelicula> PeliculaData = peliculaService.getById(id);
			
			if (PeliculaData.isPresent()) {
				return new ResponseEntity<>(PeliculaData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/peliculas")
	public ResponseEntity<PeliculaDTO> createPelicula(@RequestBody PeliculaDTO pelicula) {
		try {
			peliculaService.save(pelicula);
			return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/peliculas/{id}")
	public ResponseEntity<PeliculaDTO> updatePelicula(@PathVariable("id") long id, @RequestBody PeliculaDTO pelicula) {
		try {
			if (peliculaService.update(id, pelicula)) {
				return new ResponseEntity<>(pelicula, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/peliculas/{id}")
	public ResponseEntity<HttpStatus> deletePelicula(@PathVariable("id") long id) {
		try {
			peliculaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
