package com.ashokit.service;

import com.ashokit.entity.Ticket;
import com.ashokit.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket bookTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getTicketsByEmail(String email) {
        return ticketRepository.findByEmail(email);
    }

    @Override
    public Optional<Ticket> getTicketByTicketId(Integer ticketId) {
       return ticketRepository.findById(ticketId);
    }
}
