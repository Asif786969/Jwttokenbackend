package com.auth.authbackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authbackend.auth.JwtUtil;
import com.auth.authbackend.bean.User;
import com.auth.authbackend.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    //CRUD and other function for auth
    public HashMap<String,String> login(String username, String password) {
        User user = userRepo.findByUsername(username);
        HashMap<String,String> A=new HashMap<String,String>();
        if (user == null || !user.getPassword().equals(password)) {
          A.put("NOT FOUND","");
          return A;
         
        }
        
        String response=user.getRole();
        A.put(response,JwtUtil.generateToken(username,response));

        return A;
      }
    
      public User registerUser(User user){
        user.setUserid(UUID.randomUUID().toString().split("-")[0]);
        return userRepo.save(user);
      }

      public List<User> getAllUsers(){
        return userRepo.findAll();
      }

}
