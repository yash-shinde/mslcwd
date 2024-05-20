package com.tutorial.user.service;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorial.user.service.entities.Rating;
import com.tutorial.user.service.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired RatingService ratingService;

	@Test
	void createRating() {
		Rating rating = Rating.builder().rating(7).ratingId(UUID.randomUUID().toString())
				.hotelId(UUID.randomUUID().toString()).remarks("Not too great").build();
		Rating savedRating = this.ratingService.createRating(rating);
		
		System.out.println("new Rating Created");
	}
}
