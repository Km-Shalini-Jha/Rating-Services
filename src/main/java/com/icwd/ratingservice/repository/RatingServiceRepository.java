package com.icwd.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icwd.ratingservice.entities.RatingEntity;

@Repository
public interface RatingServiceRepository extends JpaRepository<RatingEntity, String>{
	
	// custom finder methods
	List<RatingEntity> findByUserId(String userId);
	
	List<RatingEntity> findByHotelId(String hotelId);

}
