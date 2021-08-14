package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Movie>();
		}
	}

	public Movie createMovie(Movie entity) {
		if (entity.getId() == null) {
			entity = movieRepository.save(entity);
			return entity;
		} else {
			Optional<Movie> movie = movieRepository.findById((long) entity.getId());
			if (movie.isPresent()) {
				Movie newMovie = movie.get();
				newMovie.setName(entity.getName());
				newMovie.setReleasedate(entity.getReleasedate());
				newMovie.setDescription(entity.getDescription());
				newMovie.setMedia(entity.getMedia());
				newMovie.setLanguages(entity.getLanguages());
				newMovie.setMovietype(entity.getMovietype());
				newMovie = movieRepository.save(newMovie);

				return newMovie;
			} else {

				entity = movieRepository.save(entity);
				return entity;

			}
		}

	}

	public void deleteMovieById(Long id) {
		Optional<Movie> movie = movieRepository.findById(id);

		if (movie.isPresent()) {
			movieRepository.deleteById(id);
		}

	}

	public Movie getMovieById(Long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		if(movie.isPresent()) {
			return movie.get();
		}else {
			return null;	
		}
		
	}

}
