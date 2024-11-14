package com.kartik.Services;

import java.util.List;

import com.kartik.Entity.Rating;

public interface RatingServiceInterface {
	
	Rating createRating(Rating rating);
	
	Rating getRating(String id);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
}
