package com.moviebook.service;

import org.springframework.stereotype.Service;
import com.moviebook.model.Movie;
import com.moviebook.repository.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository repository;
	
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}
	
	public Movie SalvarMovie(Movie movie) {
		Movie moviePersistido = repository.save(movie);
		return moviePersistido;
	}

}
