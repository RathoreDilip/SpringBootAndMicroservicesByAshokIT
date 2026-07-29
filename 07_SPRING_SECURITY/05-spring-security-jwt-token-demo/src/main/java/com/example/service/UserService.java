package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store=new ArrayList<>();

    public UserService(){
        User user1=new User(UUID.randomUUID().toString(),"Dilip","rathoredilip38@gmail.com");
        User user2=new User(UUID.randomUUID().toString(),"Teena","teena@gmail.com");
        User user3=new User(UUID.randomUUID().toString(),"Siya","siya@gmail.com");

        store.addAll(List.of(user1,user2,user3));

    }

    public List<User> getUsers(){
        return this.store;
    }

}
