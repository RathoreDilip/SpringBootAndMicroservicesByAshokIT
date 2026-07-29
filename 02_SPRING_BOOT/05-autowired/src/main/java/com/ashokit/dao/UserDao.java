package com.ashokit.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public UserDao(){
        System.out.println("UserDao() Bean is created...");
    }

    public String findUserNameById(int id){
        if(id==1)
            return "Raju";
        else if (id==2)
            return "Ram";
        else
            return "Invalid";
    }

}
