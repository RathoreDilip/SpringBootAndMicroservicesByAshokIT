package com.ashokit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    // represent java class as distributed controller/component
public class MsgRestController {

    @GetMapping(value = "/welcome",produces = "text/plain")  // in this method dispatcherServlet decide the http status code
    public String getWelcomeMsg(){
        String msg="Welcome to REST API...";
        return msg;
    }

    @GetMapping(value = "/greet",produces = "text/plain")   // in this method programmer will decide the http status code bcz used ResponseEntity
    public ResponseEntity<String> getGreetMsg(){
        String msg="Good Morning..";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }



}
