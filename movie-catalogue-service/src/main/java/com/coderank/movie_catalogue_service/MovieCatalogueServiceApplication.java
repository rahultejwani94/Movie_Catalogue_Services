package com.coderank.movie_catalogue_service;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogueServiceApplication {


    @Bean
    @LoadBalanced
    RestTemplate getRestTemplateObject() {
		return new RestTemplate();
	}
    
    @Bean
    WebClient.Builder getWebClientObject() {
		return WebClient.builder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogueServiceApplication.class, args);
	}

}
