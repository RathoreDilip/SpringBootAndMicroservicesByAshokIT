package com.ashokit;

import com.ashokit.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        PersonService personService = applicationContext.getBean(PersonService.class);

        personService.savePersonWithPassport();

    }

}
