package com.kartik.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartik.Entity.Rating;
import com.kartik.Exception.ResourceNotFoundException;
import com.kartik.Repository.RatingRepo;

@Service
public class RatingService implements RatingServiceInterface{

	@Autowired
	private RatingRepo ratingRepo;
	
	
	@Override
	public Rating createRating(Rating rating) {
		
		String randomId = UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		return ratingRepo.save(rating);
	}

	@Override
	public Rating getRating(String id) {
		return ratingRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Resurce not found with id " + id));
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
