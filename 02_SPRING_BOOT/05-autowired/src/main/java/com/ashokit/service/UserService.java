package com.ashokit.service;

import com.ashokit.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    //@Autowired
    private UserDao userDao;

//    public UserService(){
//        System.out.println("UserService() no param constructor is called..");
//    }

    // if only 1 param constructor is available then @Autowired is optional
//    @Autowired
    public UserService(UserDao dao){
        System.out.println("UserService() 1 param constructor is called..");
        this.userDao=dao;
    }

   // @Autowired
    public void setUserDao(UserDao userDao) {
        System.out.println("UserService() setUserDao() is called..");
        this.userDao = userDao;
    }

    public String getName(int id){
       return userDao.findUserNameById(id);
    }

}
