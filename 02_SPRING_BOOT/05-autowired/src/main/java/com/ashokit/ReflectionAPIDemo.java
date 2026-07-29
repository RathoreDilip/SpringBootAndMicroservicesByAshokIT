package com.ashokit;

import com.ashokit.dao.User;

import java.lang.reflect.Field;

//  @Autowired
//  private UserDao userDao;
//  Above is field injection, spring container internally used to initialize reflection api

public class ReflectionAPIDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("com.ashokit.dao.User");

        Object obj = clz.newInstance();
        User user=(User) obj;

        Field field = clz.getDeclaredField("age");
        field.setAccessible(true);

        field.set(user,25);

        user.printAge();

    }
}
