package com.ashokit.controller;

import com.ashokit.entity.Ticket;
import com.ashokit.exception.TicketNotFoundException;
import com.ashokit.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketRestController {

    @Autowired
    private TicketService service;

    // POST /ticket
    @PostMapping(
            value = "/ticket",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticket) {
        ticket.setTicketStatus("CONFIRMED");
        Ticket saved = service.bookTicket(ticket);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    // GET /tickets
    @GetMapping(
            value = "/tickets",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<List<Ticket>> getTickets() {
        return ResponseEntity.ok(service.getAllTickets());
    }

    // GET /tickets/{email}
    @GetMapping(
            value = "/tickets/{email}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<List<Ticket>> getTicketsByEmail(
            @PathVariable String email) {
        return ResponseEntity.ok(service.getTicketsByEmail(email));
    }

    @GetMapping(
            value = "/ticket/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Ticket> getTicketByTicketId(@PathVariable Integer id) {

        Optional<Ticket> ticket = service.getTicketByTicketId(id);

        if(ticket.isEmpty())
            throw new TicketNotFoundException("TicketId is Invalid");

        return new ResponseEntity<>(ticket.get(),HttpStatus.OK);
    }



}
