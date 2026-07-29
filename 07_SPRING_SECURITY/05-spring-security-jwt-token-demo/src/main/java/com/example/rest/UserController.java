package com.example.rest;

import com.example.model.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger logger= LoggerFactory.getLogger(UserController.class);

    @GetMapping("/test")
    public String getUser(){
        logger.debug("This is UserController... test...");
        return "Testing Message";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        System.out.println("Getting users");
        return userService.getUsers();
    }



}
