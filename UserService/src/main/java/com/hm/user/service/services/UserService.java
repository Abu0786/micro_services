package com.hm.user.service.services;

import com.hm.user.service.entities.User;

import java.util.List;

public interface UserService {
    //user operation

    //create
    User saveUser(User user);

    //get all user

    List<User> getAlluser();

    // get Single user with user Id

    User getUser(String userId);


    //update user

    // delete user


}
