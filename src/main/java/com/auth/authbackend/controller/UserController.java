package com.auth.authbackend.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authbackend.bean.UserCred;
import com.auth.authbackend.auth.JwtUtil;
import com.auth.authbackend.bean.User;
import com.auth.authbackend.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/welcome")
public class UserController {
    
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:8090")
    @GetMapping("/")
    public String App(){
        return "application running";
    }

    @CrossOrigin(origins = "http://localhost:8090")
    @PostMapping("/login")
    public HashMap<String,String> login(@RequestBody UserCred userCredentials) {
      HashMap<String,String> response=userService.login(userCredentials.getUsername(), userCredentials.getPassword());
      return response;
    
    }

    @PostMapping("/register")
    public String  register(@RequestBody User user) {
        userService.registerUser(user);
        return "User Added";
       
      }
    //@CrossOrigin(origins = "http://localhost:8090")
    @PostMapping("/auth")
    public boolean checktoken(@RequestBody String token){
        System.out.println("validate.."+token);
        if (JwtUtil.validateToken(token)){
            return true;
        }
        else{
            return false;
        }
        
    }


    @GetMapping("/allusers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/validate")
    public String validation(@RequestBody String token){
        System.out.println("validate.."+token);
        if (JwtUtil.validateToken(token)){
            return JwtUtil.getUsernameFromJwtToken(token);
        }
        else{
            return "no username";
        }
        
    }
    
}
