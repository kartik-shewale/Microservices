package com.kartik.app.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.kartik.app.Entity.User;
import com.kartik.app.Exception.ResourceNotFoundException;
import com.kartik.app.Repository.UserRepo;

@org.springframework.stereotype.Service
public class UserService implements UserServicesInterface {

	@Autowired
	private UserRepo userRepo;
	
	
	
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
	    return userRepo.findById(userId)
	                   .orElseThrow(() -> new ResourceNotFoundException("User with given id i not found on server !! : " + userId));
	}


}
