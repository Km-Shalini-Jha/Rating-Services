package com.icwd.ratingservice.services;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icwd.ratingservice.entities.RatingEntity;
import com.icwd.ratingservice.entities.RatingEntityCopy;
import com.icwd.ratingservice.exception.ResourceNotFoundException;
import com.icwd.ratingservice.repository.RatingServiceRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingServiceRepository repository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	//create 
	public RatingEntity saveRatingInfo(RatingEntity rating){
		String id = UUID.randomUUID().toString();
		rating.setRatingID(id);
		
		RatingEntityCopy ratingEntityCopy = new RatingEntityCopy();
		modelmapper.map(rating,ratingEntityCopy);
		System.out.println("modelmapper : "+ratingEntityCopy.toString());
		 
		return repository.save(rating);		
	}
	
	//getAllratings
	public List<RatingEntity> getAllratings(){		
		return repository.findAll();		
	}
	//getRatingsByUserId
	public List<RatingEntity> getRatingsByUserId(String userId) throws ResourceNotFoundException{
		
		List<RatingEntity> list = repository.findByUserId(userId);	
		return list;
	}
		
	//getRatingsByHotelId
	public List<RatingEntity> getRatingsByHotelId(String hotelId) throws ResourceNotFoundException{
		List<RatingEntity> list = repository.findByHotelId(hotelId);
		return list;	
	}

}
