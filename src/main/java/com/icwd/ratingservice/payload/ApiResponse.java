package com.icwd.ratingservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ApiResponse {
	
	private String success;
	private String message;
	private Object Data;	

}
