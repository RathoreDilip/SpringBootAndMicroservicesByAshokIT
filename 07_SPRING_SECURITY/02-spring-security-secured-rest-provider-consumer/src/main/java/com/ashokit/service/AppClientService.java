package com.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AppClientService {

    public static final String GREET_API_URL="http://localhost:8080/greet";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;


    public String callGreetApiFromRestTemplate(){
        return restTemplate.getForObject(GREET_API_URL, String.class);
    }

    public String callGreetApiFromWebClient(){
        return webClient.get()
                .uri("/greet")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
