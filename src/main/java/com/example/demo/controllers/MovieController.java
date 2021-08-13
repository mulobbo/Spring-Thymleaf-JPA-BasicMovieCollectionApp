package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Movie;
import com.example.demo.services.MovieService;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

@Controller
@RequestMapping("/")
public class MovieController {
	
@Autowired
MovieService movieService;


@RequestMapping
public String getAllMovies(Model model) {
	
	List<Movie> list = movieService.getAllMovies();
	model.addAttribute("movies",list);
	
	return "listMovie";
	
	
}

@RequestMapping(path = "/createMovie",method = RequestMethod.POST)
public String createMovie(Movie movie) {
	
	movieService.createMovie(movie);
	
	return "redirect:/";
	
}

@RequestMapping("/delete/{id}")
public String deleteMovieById(@PathVariable("id") Long id) {
	
	movieService.deleteMovieById(id);
	
	
	return "redirect:/";
}


@RequestMapping("/update/{id}")
public String updateMovieById(@PathVariable("id") Long id) {
	
	movieService.updateMovieById(id);
	
	return "redirect:/";
}



	
	
	





	
	
}
