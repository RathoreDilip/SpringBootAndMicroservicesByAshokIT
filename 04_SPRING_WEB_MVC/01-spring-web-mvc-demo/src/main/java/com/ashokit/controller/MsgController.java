package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MsgController {

    public MsgController(){
        System.out.println("MsgController :: Constructor");
    }

    @GetMapping("/greet")
    public ModelAndView greetMsg(){

        ModelAndView modelAndView=new ModelAndView();

        // setting data in the form of key-value pair
        modelAndView.addObject("msg","Good Morning");

        // setting view name
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/welcome")
    public ModelAndView getWelcomeMessage(){

        ModelAndView modelAndView=new ModelAndView();

        // setting data in the form of key-value pair
        modelAndView.addObject("msg","Welcome to Ashok It");

        // setting view name
        modelAndView.setViewName("index");

        return modelAndView;
    }

}
