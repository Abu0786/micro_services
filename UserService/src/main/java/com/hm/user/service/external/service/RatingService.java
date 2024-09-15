package com.hm.user.service.external.service;
import com.hm.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    //get

    //post
    @PostMapping("/ratings")
    public Rating createRating(Rating rating);

    //put
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId, Rating rating);


    //delete
    @DeleteMapping("/rating/{ratingId}")
    public void deletRating(@PathVariable String ratingId);
}
