package com.ashokit;

import com.ashokit.response.Ticket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//        String url="http://localhost:8080/tickets/dilip@gmail.com";
//
//        RestTemplate restTemplate=new RestTemplate();
//
//        ResponseEntity<Ticket[]> forEntity = restTemplate.getForEntity(url, Ticket[].class);
//
//        System.out.println("Status code : "+forEntity.getStatusCode());
//
//        System.out.println("response body : "+ Arrays.toString(forEntity.getBody()));



    }

}
