package com.coderank.movie_catalogue_service.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.coderank.movie_catalogue_service.dto.CatalogueItem;
import com.coderank.movie_catalogue_service.dto.MovieItem;
import com.coderank.movie_catalogue_service.dto.UserRatingItem;

@RestController
@RequestMapping("/movie-catalogue")
public class MovieCatalogueController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/{userId}")
	public List<CatalogueItem> getMovieCatalogue(@PathVariable String userId){
		// get the movie ids and ratings from ratings-data-service
		
		UserRatingItem userRatingItem = restTemplate.getForObject("http://localhost:8082/ratings-data/users/" + userId, UserRatingItem.class);
				
		// call movie-info-service for each movieId
		List<CatalogueItem> catalogueItemList = new ArrayList<>();
		
		userRatingItem.ratingItems().stream().forEach(rating -> {
			
			// calling movie-info api using RestTemplate
//			MovieItem movieItem = restTemplate.getForObject("http://localhost:8081/movie-info/" + rating.movieId(), MovieItem.class);
			
			// calling movie-info api using WebClient
			MovieItem movieItem = webClientBuilder.build()
				.get()
				.uri("http://localhost:8081/movie-info/" + rating.movieId())
				.retrieve()
				// mono means its like a container that we have initiated the call now whenever the data will arrive it will inform (asynchronous)
				.bodyToMono(MovieItem.class)
				// block is used to do the api call in synchronous manner, so it will wait till the response comes back
				.block();
					
			
			catalogueItemList.add(new CatalogueItem(movieItem.name(), "Desc", rating.rating()));			 
		});
		
		return catalogueItemList;
		//put all of them together and create CatalogueItem containing movieName, desc and rating
//		return Collections.singletonList(
//					new CatalogueItem("Past lives", "past lives korean movie", 8)
//				);
		
	}
}
