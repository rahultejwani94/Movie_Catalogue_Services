package com.coderank.ratings_data_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderank.ratings_data_service.dto.RatingItem;

@RestController
@RequestMapping("/ratings-data")
public class RatingsDataController {

	@GetMapping("/{movieId}")
	public RatingItem getRating(@PathVariable("movieId") String movieId) {
		return new RatingItem(movieId, 4);
	}
}
