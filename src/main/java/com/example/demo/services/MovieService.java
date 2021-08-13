package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> getAllMovies() {
	
		List<Movie> result = (List<Movie>) movieRepository.findAll();
		if (result.size()>0) {
			return result;
		}else {
			return new ArrayList<Movie>();
		}
	}

	public void createMovie(Movie movie) {
		
		
		
	}

	public void deleteMovieById(Long id) {
		
		
		
		
	}
	
	public void updateMovieById(Long id) {
		
		
		
	}

}
