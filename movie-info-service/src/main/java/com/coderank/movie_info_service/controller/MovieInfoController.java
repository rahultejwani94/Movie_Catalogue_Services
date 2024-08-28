package com.coderank.movie_info_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderank.movie_info_service.dto.MovieItem;

@RestController
@RequestMapping("/movie-info")
public class MovieInfoController {
	
	@GetMapping("/{movieId}")
	public MovieItem getMovieInfo(@PathVariable("movieId") String movieId){
		return new MovieItem("1", "past lives");
	}
}
