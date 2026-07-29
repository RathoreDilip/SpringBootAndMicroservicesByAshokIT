package com.ashokit.service;

import com.ashokit.binding.Quote;
import com.ashokit.entity.Ticket;
import com.ashokit.request.Passenger;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class QuoteService {

    private static final String API_URL="https://dummyjson.com/quotes/random";

    private static final String BOOK_TICKET_URL="http://localhost:8080/ticket";

    private static final String STREAM_URL="https://stream.wikimedia.org/v2/stream/recentchange";

    public void getQuote1(){
        WebClient webClient = WebClient.create();

        Mono<String> stringMono = webClient.get()
                .uri(API_URL)
                .retrieve()
                .bodyToMono(String.class);

        String stringBlock = stringMono.block(); // synchronous

        System.out.println("Response getQuote1() String : "+stringBlock);
    }

    public void getQuote2(){
        WebClient webClient = WebClient.create();

        Mono<Quote> quoteMono = webClient.get()
                .uri(API_URL)
                .retrieve()
                .bodyToMono(Quote.class);

        Quote quoteBlock = quoteMono.block();  // synchronous

        System.out.println("Response getQuote2() Quote : "+quoteBlock);
    }

    public void getQuote3(){
        WebClient webClient = WebClient.create();

        System.out.println("====== Request sending - Started ========= ");

        webClient.get()
                .uri(API_URL)
                .retrieve()
                .bodyToMono(Quote.class)
                .subscribe( response -> {          // asynchronous call
                    // handle response
                    //System.out.println("Response : "+response);
                    handleResponse(response);
                });

        System.out.println("====== Request sending - Completed ========= ");
    }

    private void handleResponse(Quote response) {
        System.out.println("Response : "+response);
    }

    public void bookTicket(Passenger passenger){

        WebClient webClient = WebClient.create();

        Ticket ticketResponse = webClient.post()
                .uri(BOOK_TICKET_URL)
                .body(BodyInserters.fromValue(passenger))
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();

        System.out.println("bookTicket Ticket : "+ticketResponse);

    }

    public void getStreamFluxDemo(){

        WebClient webClient=WebClient.create();

        webClient.get()
                .uri(STREAM_URL)
                .retrieve()
                .bodyToFlux(String.class)
                .take(10)
                //.take(Duration.ofSeconds(10))
                .subscribe( res -> {
                    System.out.println("Response : "+res);
                    System.out.println("======= GetMessageAsStream =======");
                });

    }

}
