package com.ashokit.controller;

import com.ashokit.exception.ProductNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String getProduct(@RequestParam("pid") Integer pid, Model model){
        if(pid==1)
            model.addAttribute("msg","Product Name : Apple");
        else
            throw new ProductNotFoundException("No Record Found");

        return "index";
    }

}
