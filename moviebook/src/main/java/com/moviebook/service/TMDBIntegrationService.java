package com.moviebook.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.moviebook.model.Authentication;
import com.moviebook.model.Movie;

@Service
public class TMDBIntegrationService {

    private RestTemplate restTemplate;
    
    private MovieService service;

    @Value("${tmdb-external-api}")
    private String uri;

    @Value("${tmdb-api-key}")
    private String apiKey;
    
    @Value("${tmdb-auth}")
    private String auth;

    public TMDBIntegrationService(RestTemplateBuilder restTemplateBuilder, MovieService service) {
        this.restTemplate = restTemplateBuilder.build();
        this.service = service;
    }

    public Movie findById(int id) {
        String url = generateURLIntegration(id);
        Movie movie = this.restTemplate.getForObject(url, Movie.class);
        return service.SalvarMovie(movie);
    }

    public Authentication criarRequest() {
    	String url = generateURLAuthentication();
    	return this.restTemplate.getForObject(url, Authentication.class);
    }
    
    private String generateURLIntegration(int id) {
        return this.uri + "/movie/" + id + "?api_key=" + this.apiKey ;
    }
    
    private String generateURLAuthentication() {
    	return this.auth + "api_key=" + this.apiKey;
    }
    
}
