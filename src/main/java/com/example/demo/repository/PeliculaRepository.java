package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pelicula;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {

}
