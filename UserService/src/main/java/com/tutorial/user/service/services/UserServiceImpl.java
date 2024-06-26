package com.tutorial.user.service.services;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tutorial.user.service.entities.Hotel;
import com.tutorial.user.service.entities.Rating;
import com.tutorial.user.service.entities.Users;
import com.tutorial.user.service.exceptions.ResourceNotFoundException;
import com.tutorial.user.service.external.services.HotelService;
import com.tutorial.user.service.external.services.RatingService;
import com.tutorial.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired private HotelService hotelService;
	@Autowired private RatingService ratingService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public Users saveUser(Users user) {
		String randomUUID = UUID.randomUUID().toString();
		user.setId(randomUUID);
		return userRepo.save(user);
	}

	@Override
	public List<Users> getAllUSers() {
		return userRepo.findAll();
	}

	@Override
	public Users getUserById(String id) {
		// get single user by id
		Users user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with given Id not found on Server"));
		// fetch ratings for the above user
		// http://localhost:8082/ratings/user/c697161f-81e3-4ac7-8495-4a51db0cc35c
//		Rating[] ratings_by_user = restTemplate
//				.getForObject("http://RATING-SERVICE/ratings/user/"+id, Rating[].class);
		
		Rating[] ratings_by_user = ratingService.getRatingsForUser(id);
		logger.info("{}",ratings_by_user);
		
//		ratings_by_user.stream().forEach(rating -> {
//			//call api and set the hotel for the rating
//			Object hotel = restTemplate.getForObject("http://localhost:8083/hotels/"+rating.getHotelId(),Object.class);
//			logger.info("{}",hotel);
//			//rating.setHotel(hotel);
//		});
		
		List<Rating> ratingsList = Arrays.stream(ratings_by_user).toList();
		
		 ratingsList = ratingsList.stream().map(elem -> {
//			ResponseEntity<Hotel> forEntity = restTemplate
//					.getForEntity("http://HOTEL-SERVICE/hotels/"+elem.getHotelId(),Hotel.class);
			Hotel hotel = hotelService.getHotel(elem.getHotelId());
			logger.info("{}",hotel);
			elem.setHotel(hotel);
			return elem;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingsList);
		return user;
	}

}
