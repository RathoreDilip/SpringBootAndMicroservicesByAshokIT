package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    public ProductController(){
        System.out.println("ProductController:: Constructor");
    }

    @GetMapping("/product")
    public ModelAndView getProductPrice(){
        ModelAndView modelAndView=new ModelAndView();

        // set data
        modelAndView.addObject("price","Apple Mobile Price :: 65000 INR");

        // set view name
        modelAndView.setViewName("productPage");

        return modelAndView;
    }

}
