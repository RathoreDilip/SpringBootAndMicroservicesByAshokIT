package com.ashokit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-beans.xml");
        ATM atm = context.getBean(ATM.class);
        atm.withdraw(20);
    }
}
