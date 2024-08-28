package com.coderank.ratings_data_service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderank.ratings_data_service.dto.RatingItem;
import com.coderank.ratings_data_service.dto.UserRatingItem;

@RestController
@RequestMapping("/ratings-data")
public class RatingsDataController {

	@GetMapping("/{movieId}")
	public RatingItem getRating(@PathVariable String movieId) {
		return new RatingItem(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRatingItem getRatingByUserId(@PathVariable String userId){
		 List<RatingItem> ratingsItem = Arrays.asList(
				new RatingItem("1",5),
				new RatingItem("2", 8),
				new RatingItem("3", 10)
			);
		 
		 UserRatingItem userRatingItem = new UserRatingItem(ratingsItem);
		 return userRatingItem;
		 
	}
}

