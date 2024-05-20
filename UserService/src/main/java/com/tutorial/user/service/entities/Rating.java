package com.tutorial.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating{

	private String ratingId;
	private String id;
	private String hotelId;
	private int rating;
	private String remarks;
	private Hotel hotel;
}
