package com.ashokit.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UserDAO {
    public UserDAO(){
        System.out.println("UserDAO() constructor is called..");
    }
}
