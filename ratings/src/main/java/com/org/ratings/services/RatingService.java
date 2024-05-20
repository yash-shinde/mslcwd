package com.org.ratings.services;

import java.util.List;

import com.org.ratings.entities.Rating;

public interface RatingService {

	//create
	Rating createRating(Rating rating);
	
	//get all
	List<Rating> getAllRatings();
	
	//get all by user id	
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotel id
	List<Rating> getRatingsByHotelId(String hotelId);
}
