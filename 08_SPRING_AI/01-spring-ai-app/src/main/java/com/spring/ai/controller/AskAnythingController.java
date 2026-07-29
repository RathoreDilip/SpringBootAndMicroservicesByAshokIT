package com.spring.ai.controller;

import com.spring.ai.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AskAnythingController {

    @Autowired
    private OpenAIService openAIService;

    @GetMapping("/showAskAnything")
    public String showAskAnythingPage(Model model){
        return "askAnything";
    }

    @PostMapping("/askAnything")
    public String handleAskAnythingPage(@RequestParam String question,Model model){
        String answer = openAIService.askAnything(question);

        model.addAttribute("question",question);
        model.addAttribute("answer",answer);

        return "askAnything";
    }



}
