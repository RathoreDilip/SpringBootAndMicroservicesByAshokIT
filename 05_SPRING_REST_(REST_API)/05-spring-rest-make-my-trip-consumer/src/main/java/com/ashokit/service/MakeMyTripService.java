package com.ashokit.service;

import com.ashokit.request.Passenger;
import com.ashokit.response.Ticket;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class MakeMyTripService {

    private static final String BOOK_TICKET_URL="http://localhost:8080/ticket";

    private static final String GET_ALL_TICKETS_URL="http://localhost:8080/tickets";

    private static final String GET_ALL_TICKETS_BY_EMAIL_URL="http://localhost:8080/tickets/{email}";

    private final RestTemplate restTemplate=new RestTemplate();

    public Ticket bookTicket(Passenger passenger){

        ResponseEntity<Ticket> ticketResponseEntity = restTemplate.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);

        System.out.println("Status code bookTicket : "+ticketResponseEntity.getStatusCode());

        Ticket ticket=ticketResponseEntity.getBody();

        System.out.println("Ticket : "+ticket);

        return ticket;
    }

    public Ticket[] getAllTickets(){

        ResponseEntity<Ticket[]> forEntity = restTemplate.getForEntity(GET_ALL_TICKETS_URL, Ticket[].class);

        System.out.println("Status code getAllTickets : "+forEntity.getStatusCode());

        Ticket[] body = forEntity.getBody();

        System.out.println("getAllTickets : "+ Arrays.toString(body));

        getAllTicketsByEmail("dilip@gmail.com");

        return body;
    }

    public List<Ticket> getAllTicketsByEmail(String email){

        Map<String,String> uriVariables=new HashMap<>();
        uriVariables.put("email",email);

        ResponseEntity<List<Ticket>> getAllTicketBasedOnEntity = restTemplate.exchange(GET_ALL_TICKETS_BY_EMAIL_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Ticket>>() {
                },
                uriVariables);

        System.out.println("getAllTicketsByEmail Status code : "+getAllTicketBasedOnEntity.getStatusCode());

        List<Ticket> body = getAllTicketBasedOnEntity.getBody();

        System.out.println("getAllTicketsByEmail Response Body : "+body);

        return new ArrayList<>();
    }

}
