package com.tutorial.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tutorial.user.service.entities.Rating;
@Service
@FeignClient("RATING-SERVICE")
public interface RatingService {

	@GetMapping("/ratings/user/{ratingId}")
	Rating[] getRatingsForUser(@PathVariable String ratingId);
	
	@PostMapping("/ratings")
	Rating createRating(@RequestBody Rating rating);
	
	//PUT
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable String ratingId,@RequestBody Rating rating);
	
	//DELETE
	@DeleteMapping("ratings/{ratingId")
	void deleteRating(@PathVariable String ratingId);
	

	
}
