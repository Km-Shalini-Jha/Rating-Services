package com.icwd.ratingservice;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class RatingServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServicesApplication.class, args);		
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapperr = new ModelMapper();
		modelMapperr.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapperr;
	}
}
