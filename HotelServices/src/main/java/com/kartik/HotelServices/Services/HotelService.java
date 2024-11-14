package com.kartik.HotelServices.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartik.HotelServices.Entity.Hotel;
import com.kartik.HotelServices.Exception.ResourceNotFoundException;
import com.kartik.HotelServices.Repository.HotelRepo;


@Service
public class HotelService implements HotelServiceInterface{

	@Autowired
	private HotelRepo hRepo;
	
	@Override
	public Hotel create(Hotel hotel) {
		
		String randomIdString = UUID.randomUUID().toString();
		hotel.setHotelId(randomIdString);
		
		return hRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hRepo.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource Not found with Id " + id));
	}

}
