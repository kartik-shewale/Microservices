package com.kartik.app.Service;

import java.util.List;

import com.kartik.app.Entity.User;

public interface UserServicesInterface {

	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String UserId);
	
	
}
