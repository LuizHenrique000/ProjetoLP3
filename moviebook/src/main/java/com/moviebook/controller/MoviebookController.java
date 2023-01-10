package com.moviebook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moviebook.model.Authentication;
import com.moviebook.model.Movie;
import com.moviebook.service.TMDBIntegrationService;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MoviebookController {

    private TMDBIntegrationService tmdbIntegrationService;

    public MoviebookController(TMDBIntegrationService tmdbIntegrationService) {
        this.tmdbIntegrationService = tmdbIntegrationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.tmdbIntegrationService.findById(id));
    }
    
    @GetMapping("/auth")
    public ResponseEntity<Authentication> getAuth(){
    	return ResponseEntity.ok(this.tmdbIntegrationService.criarRequest());
    }

}