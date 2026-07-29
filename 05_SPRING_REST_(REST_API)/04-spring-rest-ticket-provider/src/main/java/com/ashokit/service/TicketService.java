package com.ashokit.service;

import com.ashokit.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    Ticket bookTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    List<Ticket> getTicketsByEmail(String email);

    Optional<Ticket> getTicketByTicketId(Integer id);
}
