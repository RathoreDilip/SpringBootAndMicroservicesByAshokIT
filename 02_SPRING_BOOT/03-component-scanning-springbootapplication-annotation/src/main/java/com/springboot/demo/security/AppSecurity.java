package com.springboot.demo.security;

import org.springframework.stereotype.Component;

public class AppSecurity {

    private String algo;

    public AppSecurity(String algo){
        System.out.println("AppSecurity() constructor is called..");
        this.algo=algo;
    }
}
