package com.ph.dsmovie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ph.dsmovie.entities.Movie;
import com.ph.dsmovie.entities.dto.MovieDTO;
import com.ph.dsmovie.entities.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> movies = repository.findAll(pageable);
		return movies.map(movie -> new MovieDTO(movie));
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
		Optional<Movie> movies = repository.findById(id);
		Movie movie = movies.orElseThrow(() -> new IllegalArgumentException());
		return new MovieDTO(movie);
	}
	
	
}
