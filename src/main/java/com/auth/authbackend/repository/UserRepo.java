package com.auth.authbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auth.authbackend.bean.User;

public interface UserRepo extends MongoRepository<User,String> {

    User findByUsername(String username);
    
}
