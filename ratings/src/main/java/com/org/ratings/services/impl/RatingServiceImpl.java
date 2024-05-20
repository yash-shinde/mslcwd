package com.org.ratings.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.ratings.entities.Rating;
import com.org.ratings.repository.RatingsRepository;
import com.org.ratings.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired private RatingsRepository ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
