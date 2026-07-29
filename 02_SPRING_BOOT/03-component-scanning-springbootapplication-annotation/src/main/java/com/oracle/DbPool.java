package com.oracle;

import org.springframework.stereotype.Component;

@Component
public class DbPool {
    public DbPool(){
        System.out.println("DbPool() constructor is called...");
    }
}
