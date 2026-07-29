package com.springboot.demo.service;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    public UserService(){
        System.out.println("UserService() constructor is call...");
    }
}
