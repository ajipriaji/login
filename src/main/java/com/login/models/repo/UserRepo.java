package com.login.models.repo;

import com.login.models.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    
    // @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
    
}
