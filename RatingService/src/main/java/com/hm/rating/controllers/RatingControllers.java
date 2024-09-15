package com.hm.rating.controllers;

import com.hm.rating.entities.Rating;
import com.hm.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingControllers {
    @Autowired
    private RatingService ratingService;

    //create Rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }


    //get All ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getAllRatings());
    }
    //get All ratings by UserId
    @GetMapping("/users/{userId}")
    public  ResponseEntity<List<Rating>> getRatingBYUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getAllRatingsBYUserId(userId));
    }

    //get All ratings by Hotel Id
    @GetMapping("/hotels/{hotelId}")
    public  ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return  ResponseEntity.ok(ratingService.getAllRatingsBYHotelId(hotelId));
    }

}
