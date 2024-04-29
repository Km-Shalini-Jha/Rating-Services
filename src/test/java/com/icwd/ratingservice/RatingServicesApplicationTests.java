package com.icwd.ratingservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.icwd.ratingservice.entities.RatingEntity;
import com.icwd.ratingservice.repository.RatingServiceRepository;

@SpringBootTest(classes = RatingServicesApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration
class RatingServicesApplicationTests {
	
	@Autowired
	private RatingServiceRepository repository;
	

	@Test
	@Order(1)
	void contextLoads() {
	} 

    @Test
    @Order(2)
    @Rollback(value = false)
    public void testSaveRatingInfo() {
        RatingEntity rating = new RatingEntity("10",8,"It is very good Hotel","1","1");
        repository.save(rating);
        assertNotNull(rating.getRatingID());
    }
    
    @Test
    @Order(3)
    public void testGetAllratings(){
    	List<RatingEntity> list = repository.findAll();
        Assertions.assertThat(list.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void testGetRatingsByUserId() {   	
    	List<RatingEntity> list = repository.findByUserId("1");
    	Assertions.assertThat(list.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void testGetRatingsByHotelId(){   	
    	List<RatingEntity> list = repository.findByHotelId("1");
    	Assertions.assertThat(list.size()).isGreaterThan(0);	    	
    }



}
