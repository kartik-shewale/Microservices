package com.kartik.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rating")
public class Rating {

	@Id
	private String ratingId;
	
	private String userId;
	
	private String hotelId;
	
	private int rating;
	
	private String feedBack;

	public Rating() {
		super();
	}

	public Rating(String ratingId, String userId, String hotelId, int rating, String feedBack) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedBack = feedBack;
	}

	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
}
