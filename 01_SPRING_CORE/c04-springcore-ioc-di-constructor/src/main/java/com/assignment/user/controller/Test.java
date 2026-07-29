package com.assignment.user.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-beans.xml");
        UserController userController = context.getBean(UserController.class);

        userController.serviceCall();

    }
}
