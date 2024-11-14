package com.kartik.HotelServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kartik.HotelServices.Entity.Hotel;


@Repository
public interface HotelRepo extends JpaRepository<Hotel, String>{

}
