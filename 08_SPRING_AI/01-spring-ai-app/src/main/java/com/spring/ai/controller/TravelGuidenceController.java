package com.spring.ai.controller;

import com.spring.ai.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TravelGuidenceController {

    @Autowired
    private OpenAIService openAIService;

    @GetMapping("/showTravelGuide")
    public String showTravelGuide(){
        return "travelGuide";
    }

    @PostMapping("/showTravelGuide")
    public String getTravelGuidenceResponse(@RequestParam("place") String place,
                                            @RequestParam("month")  String month,
                                            @RequestParam("language") String language,
                                            @RequestParam("budget")  String budget,
                                            Model model){

        String travelGuidenceResponse = openAIService.getTravelGuidence(place, month, language, budget);

        model.addAttribute("place",place);
        model.addAttribute("response",travelGuidenceResponse);

        return "travelGuide";
    }


}
