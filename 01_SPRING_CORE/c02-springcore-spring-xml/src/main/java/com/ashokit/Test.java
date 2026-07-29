package com.ashokit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-beans.xml");
        Engine engBean = context.getBean(Engine.class);
        engBean.start();

        Car carBean = context.getBean(Car.class);
        carBean.drive();
    }
}
