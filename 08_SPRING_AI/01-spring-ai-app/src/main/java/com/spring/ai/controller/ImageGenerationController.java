package com.spring.ai.controller;

import com.spring.ai.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImageGenerationController {

    @Autowired
    private OpenAIService openAIService;

    @GetMapping("/imageGenerator")
    public String showImageGeneratorPage(){
        return "imageGenerator";
    }

    @PostMapping("/imageGenerator")
    public String generateImage(@RequestParam String prompt, Model model){
        String imageUrl= openAIService.generateImage(prompt);

        model.addAttribute("image",imageUrl);

        return "imageGenerator";
    }

}
