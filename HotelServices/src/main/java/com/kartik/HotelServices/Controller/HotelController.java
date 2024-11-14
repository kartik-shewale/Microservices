package com.kartik.HotelServices.Controller;

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

import com.kartik.HotelServices.Entity.Hotel;
import com.kartik.HotelServices.Services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hService.create(hotel));
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getUser(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hService.get(hotelId));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllUser()
	{
		return ResponseEntity.status(HttpStatus.OK).body(hService.getAll());
	}

}
