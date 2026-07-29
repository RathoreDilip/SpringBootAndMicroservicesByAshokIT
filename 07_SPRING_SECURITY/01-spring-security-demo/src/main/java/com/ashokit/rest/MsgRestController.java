package com.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

    @GetMapping("/welcome")
    public String getWelcome(){
        return "You are Welcome";
    }

    @GetMapping("/greet")
    public String greet(){
        return "Good Morning..!";
    }

}
