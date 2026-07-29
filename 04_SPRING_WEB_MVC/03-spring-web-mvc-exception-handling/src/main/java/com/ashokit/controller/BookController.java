package com.ashokit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private Logger logger= LoggerFactory.getLogger(MsgController.class);

    @GetMapping("/book")
    public String getBook(Model model){
        int i=10/0;
        model.addAttribute("msg","Book reading is good habbit...");
        return "index";
    }
}
