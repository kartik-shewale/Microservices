package com.kartik.app.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.kartik.app.Entity.Hotel;
import com.kartik.app.Entity.Rating;
import com.kartik.app.Entity.User;
import com.kartik.app.Exception.ResourceNotFoundException;
import com.kartik.app.Repository.UserRepo;

@org.springframework.stereotype.Service
public class UserService implements UserServicesInterface {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	HotelService hotelService;
	
	
	@Override
	public User saveUser(User user) {
		String randomUserID	= UUID.randomUUID().toString(); 
		user.setUserId(randomUserID);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
	    User user = userRepo.findById(userId)
	                   .orElseThrow(() -> new ResourceNotFoundException("User with given id i not found on server !! : " + userId));
	
	    //http://localhost:1003/ratings/users/e6822a35-a7d6-4127-b09a-0769d05bcd7f
	Rating[] list = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
	   
	List<Rating> ratings = Arrays.stream(list).toList();
	//http://localhost:1002/hotels/22bb2557-e418-4526-a3ad-9a72f4eb579a
	
	List<Rating> ratingsList = ratings.stream().map(rating -> {
		
		//Without feign client
		//ResponseEntity<Hotel> response = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+ rating.getHotelId(), Hotel.class);
		//Hotel hotel = response.getBody();
		
		Hotel hotel = hotelService.getHotel(rating.getHotelId());
		rating.setHotel(hotel);
		return rating;
		
	}).collect(Collectors.toList());
	   
	   user.setRatings(ratingsList);
	    
	    return user;
	}


}
