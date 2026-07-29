package com.ashokit.service;

import com.ashokit.entity.Role;
import com.ashokit.entity.User;
import com.ashokit.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUserWithRoles(){
        User user1=new User();
        user1.setName("Deep");
        user1.setGender("Male");

        User user2=new User();
        user2.setName("Tina");
        user2.setGender("Female");

        Role role1=new Role();
        role1.setRoleName("Manager");

        Role role2=new Role();
        role2.setRoleName("Owner");

        user1.setRoles(Arrays.asList(role1));

        user2.setRoles(List.of(role1,role2));

        userRepository.saveAll(List.of(user1,user2));


    }

}
