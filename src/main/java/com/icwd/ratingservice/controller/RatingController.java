package com.icwd.ratingservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icwd.ratingservice.entities.RatingEntity;
import com.icwd.ratingservice.exception.ResourceNotFoundException;
import com.icwd.ratingservice.payload.ApiResponse;
import com.icwd.ratingservice.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	// create
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> saveRatingInfo(@RequestBody RatingEntity rating){
		RatingEntity ratingData = ratingService.saveRatingInfo(rating);
		return new ResponseEntity<>(new ApiResponse("true","Data Saved Successfully",ratingData),HttpStatus.CREATED);		
	}
	
	//getAllratings
	@GetMapping("/getAllRating")
	public ResponseEntity<ApiResponse> getAllratings(){
		List<RatingEntity> list = ratingService.getAllratings();
		return new ResponseEntity<ApiResponse>(new ApiResponse("true","list of all ratings",list),HttpStatus.OK);		
	}
	
	//getRatingsByUserId
	@GetMapping("/getRatingForUser/{userId}")
	public ResponseEntity<ApiResponse> getRatingsByUserId(@PathVariable String userId){
		List<RatingEntity> list = new ArrayList<>();
		try {
			list = ratingService.getRatingsByUserId(userId);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse("true","list of all ratings by a user",list),HttpStatus.OK);			
	}
	
	//getRatingsByHotelId
	@GetMapping("/getHotelRating")
	public ResponseEntity<ApiResponse> getRatingsByHotelId(@RequestParam("hotelId") String hotelId){
		List<RatingEntity> list = new ArrayList<>();
		try {
			list = ratingService.getRatingsByHotelId(hotelId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("true","list of all ratings for a hotel",list),HttpStatus.OK);			
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<ApiResponse>(new ApiResponse("false","No data found",e),HttpStatus.OK);			
		}
		
	}
}
