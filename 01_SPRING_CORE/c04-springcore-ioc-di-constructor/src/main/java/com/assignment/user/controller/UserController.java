package com.assignment.user.controller;

import com.assignment.user.service.UserService;

public class UserController {
    private UserService userService;

    public UserController(){
        System.out.println("UserController() no args constructor...");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void serviceCall(){
        userService.callAllService();
    }

}
