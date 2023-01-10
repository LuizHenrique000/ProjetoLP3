package com.moviebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebook.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
