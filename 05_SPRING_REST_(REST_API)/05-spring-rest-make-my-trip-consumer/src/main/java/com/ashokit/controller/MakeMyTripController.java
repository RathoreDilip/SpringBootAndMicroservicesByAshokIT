package com.ashokit.controller;

import com.ashokit.request.Passenger;
import com.ashokit.response.Ticket;
import com.ashokit.service.MakeMyTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MakeMyTripController {

    @Autowired
    private MakeMyTripService service;

    @GetMapping("/")
    public String index(Model model){

        Ticket[] allTickets = service.getAllTickets();

        model.addAttribute("tickets",allTickets);

        return "index";
    }

    @GetMapping("/bookTicket")
    public String loadTicketBookingPage(Model model){
        Passenger passenger=new Passenger();

        model.addAttribute("passenger",passenger);

        return "bookTicket";
    }

    @PostMapping("/saveTicket")
    public String saveTicket(Passenger passenger,Model model){
        System.out.println("Form Data : "+passenger);

        Ticket ticket = service.bookTicket(passenger);

        model.addAttribute("ticket",ticket);

        System.out.println(ticket);

        return "bookTicket";
    }



}
