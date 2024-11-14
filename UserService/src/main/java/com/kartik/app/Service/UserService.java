package com.kartik.app.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

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
	   @SuppressWarnings("unchecked")
	ArrayList<Rating> list = restTemplate.getForObject("http://localhost:1003/ratings/users/"+userId, ArrayList.class);
	    user.setRatings(list);
	    
	    return user;
	}


}
