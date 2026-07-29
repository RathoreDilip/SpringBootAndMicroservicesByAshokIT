package com.ashokit;

import com.ashokit.request.Passenger;
import com.ashokit.service.QuoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        QuoteService quoteService = applicationContext.getBean(QuoteService.class);

//        quoteService.getQuote1();
//        quoteService.getQuote2();

//        quoteService.getQuote3();

        Passenger passenger=new Passenger();
        passenger.setDestination("Mathura");
        passenger.setSource("Surat");
        passenger.setDob("10-07-1995");
        passenger.setEmail("rathoredilip38@gmail.com");
        passenger.setDoj("02-01-2026");
        passenger.setGender("Male");
        passenger.setName("Dilip");
        passenger.setTrainNum("12205");

        quoteService.bookTicket(passenger);

//        quoteService.getStreamFluxDemo();


    }

}
