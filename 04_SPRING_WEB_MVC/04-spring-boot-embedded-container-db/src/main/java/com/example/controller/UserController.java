package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user",new User());
        return "index";
    }

    @PostMapping("/user")
    public String saveUser(@Valid User user, BindingResult bindingResult,Model model){
        // form validation failed...
        if(bindingResult.hasErrors()){
            return "index";
        }

        // form validation success..
        System.out.println("UserController : "+user);
        boolean isSave = userService.saveUser(user);
        if(isSave)
            model.addAttribute("msg","User Saved...");
        else
            model.addAttribute("emsg","User Not Saved..");

        return "index";
    }

}
