package com.org.ratings.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.ratings.entities.Rating;

public interface RatingsRepository extends MongoRepository<Rating, String>{

	//custom finder methods
	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
}
