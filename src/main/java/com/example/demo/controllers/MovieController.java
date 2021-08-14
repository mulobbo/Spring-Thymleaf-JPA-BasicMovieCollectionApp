package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Movie;
import com.example.demo.services.MovieService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping
	public String getAllMovies(Model model) {

		List<Movie> list = movieService.getAllMovies();
		model.addAttribute("movies", list);

		return "listMovie";

	}
	
	
	@RequestMapping("/add")
	public String prepareMovie(Model model ){
		
			model.addAttribute("movie", new Movie() );
			
		
		
		return "addMovie";
	}
   
	@RequestMapping("/update/{id}")
	public String updateMovieById(Model model ,@PathVariable("id") Optional<Long> id) {
		
		if (id.isPresent()) {
            Movie movie = movieService.getMovieById((Long)id.get());
            model.addAttribute("movie",movie);
            
		}
		
		return "updateMovie";
	}
	
	

	@RequestMapping(path = "/createMovies", method = RequestMethod.POST)
	public String createMovies(Movie movie) {

		movieService.createMovie(movie);

		return "redirect:/";

	}

	@RequestMapping("/delete/{id}")
	public String deleteMovieById(@PathVariable("id") Long id) {

		movieService.deleteMovieById(id);

		return "redirect:/";
	}

	@RequestMapping(path = "/createMovie", method = RequestMethod.POST)
	public String updateMovieById(Movie movie) {

		return "redirect:/";
	}

}
