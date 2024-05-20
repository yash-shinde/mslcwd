package com.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.repositories.HotelRepository;
import com.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired private HotelRepository hotelRepo;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return this.hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return this.hotelRepo.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		return this.hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given Id Not Found"));
	}

}
