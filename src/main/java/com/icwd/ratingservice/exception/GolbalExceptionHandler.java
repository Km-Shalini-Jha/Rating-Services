package com.icwd.ratingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.icwd.ratingservice.payload.ApiResponse;

@RestControllerAdvice
public class GolbalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResponseEresourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		return new ResponseEntity(new ApiResponse("FALSE","Data not found",ex.getMessage()),HttpStatus.NOT_FOUND);
	}
}
