package com.coderank.movie_catalogue_service.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderank.movie_catalogue_service.dto.CatalogueItem;

@RestController
@RequestMapping("/movie-catalogue")
public class MovieCatalogueController {

	@GetMapping("/{userId}")
	public List<CatalogueItem> getMovieCatalogue(@PathVariable("userId") String userId){
		return Collections.singletonList(
					new CatalogueItem("Past lives", "past lives korean movie", 8)
				);
		
	}
}
