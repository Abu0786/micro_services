package com.hm.user.service.services.impl;

import com.hm.user.service.entities.Hotel;
import com.hm.user.service.entities.Rating;
import com.hm.user.service.entities.User;
import com.hm.user.service.exceptions.ResourceNotFoundExceptions;
import com.hm.user.service.external.service.HotelService;
import com.hm.user.service.repositories.UserRepository;
import com.hm.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceInpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceInpl.class);

    @Override
    public User saveUser(User user) {
        //generate unique Id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAlluser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //get User from data base with the help of user repository
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundExceptions("User with given Id is not found on server!!; "+userId));
        //fetch ratings of the above user from rating service
        // http://localhost:8083/ratings/users/1a35b638-1e9d-40dc-920d-1813cd8b6614
        Rating[] ratingsOfUsers=restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{} ",ratingsOfUsers);
        List<Rating> ratings = Arrays.stream(ratingsOfUsers).toList();

        List<Rating> ratingList=ratings.stream().map(rating->{
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/dd0b00d5-9139-4a38-8a20-6a51852c8cb3
           // ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
           // Hotel hotel = forEntity.getBody();
            //logger.info("status code::{}",forEntity.getStatusCode());

            Hotel hotel=hotelService.getHotel(rating.getHotelId());

            //set the hotel rating
            rating.setHotel(hotel);

            //return the hotelrating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
