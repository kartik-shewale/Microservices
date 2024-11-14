package com.kartik.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartik.Entity.Rating;
import com.kartik.Services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService rService;
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		
		Rating rating2 = rService.createRating(rating);
		return ResponseEntity.status(HttpStatus.OK).body(rating2);
	}
	
	@GetMapping("/{RatingId}")
	public ResponseEntity<Rating> getRating(@PathVariable String RatingId){
		
		Rating rating2 = rService.getRating(RatingId);
		return ResponseEntity.status(HttpStatus.OK).body(rating2);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		
		List<Rating> rating2 = rService.getAllRating();
		return ResponseEntity.status(HttpStatus.OK).body(rating2);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		
		List<Rating> rating2 = rService.getRatingByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(rating2);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		
		List<Rating> rating2 = rService.getRatingByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(rating2);
	}
}
