package com.kartik.HotelServices.Services;

import java.util.List;

import com.kartik.HotelServices.Entity.Hotel;

public interface HotelServiceInterface {
	
	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel get(String id);

}
