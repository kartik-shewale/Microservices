package com.kartik.app.Controller;

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

import com.kartik.app.Entity.User;
import com.kartik.app.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	//Create
	@PostMapping
	public ResponseEntity<User> createUserEntity(@RequestBody User user)
	{
		User user2 = service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	
	
	//Single user
	@GetMapping("/{userID}")
	public ResponseEntity<User> getSingleUserEntity (@PathVariable String userID)
	{
		User user = service.getUser(userID);
		return ResponseEntity.ok(user);
	}
	
	
	//All User
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User>  list = service.getAllUser();
		return ResponseEntity.ok(list);
	}
	
	

}
