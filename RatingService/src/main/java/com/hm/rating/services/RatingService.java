package com.hm.rating.services;

import com.hm.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    //create

    Rating create(Rating rating);

    //get All Ratings

    List<Rating> getAllRatings();

    //get All Ratings By User Id

    List<Rating> getAllRatingsBYUserId(String userId);

    // get All by hotels

    List<Rating> getAllRatingsBYHotelId(String hotelId);


}
