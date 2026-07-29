package com.ashokit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {


    private Logger logger=LoggerFactory.getLogger(MsgController.class);

    @GetMapping("/welcome")
    public String getWelcomeMsg(Model model){
        int i=10/0;
        model.addAttribute("msg","Welcome to Ashok IT");
        return "index";
    }

    @GetMapping("/greet")
    public String greetMessage(Model model){
        model.addAttribute("msg","Good morning..");
        return "index";
    }

//    @ExceptionHandler(value = Exception.class)
//    public String handleException(Exception e){
//        logger.error(e.getMessage());
//        return "errorPage";
//    }



}
