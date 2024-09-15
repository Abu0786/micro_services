package com.hm.user.service.repositories;

import com.hm.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    // If you want any custom method
}
