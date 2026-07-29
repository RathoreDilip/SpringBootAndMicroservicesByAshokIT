package com.ashokit;

import com.ashokit.service.AppClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        AppClientService appClientService = applicationContext.getBean(AppClientService.class);

        System.out.println("api call from restTemplate : "+appClientService.callGreetApiFromRestTemplate());

        System.out.println("api call from webClient : "+appClientService.callGreetApiFromWebClient());

    }

}
