package com.ashokit.rest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataRestController {

    @GetMapping("/data")
    @CircuitBreaker(fallbackMethod = "getDataFromDb",name = "ashokIt")
    public String getDataFromRedis(){
        System.out.println("Redis() method called...");
        int i=10/0;
        return "Retrieve Data from Redis";
    }

    public String getDataFromDb(Throwable throwable){
        System.out.println("Db() method called...");
        return "Retrieve Data from DataBase";
    }

}
