package com.icwd.ratingservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RatingEntityCopy {
	
	private String ratingID;
	private int rating;
	private String feedback;
	private String userId;
	private String hotelId;
	
	
}
