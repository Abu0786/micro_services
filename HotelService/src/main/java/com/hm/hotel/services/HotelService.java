package com.hm.hotel.services;

import com.hm.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create

    Hotel create(Hotel hotel);


    //getAll

    List<Hotel> getAllHotel();

    //getSingle hotel

    Hotel getHotelById(String hotelId);
}
