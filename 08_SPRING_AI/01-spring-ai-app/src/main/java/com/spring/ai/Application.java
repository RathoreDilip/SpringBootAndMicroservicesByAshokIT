package com.spring.ai;

//import com.spring.ai.service.OpenAIService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        SpringApplication.run(Application.class, args);

       // OpenAIService openAIService = applicationContext.getBean(OpenAIService.class);

       // String askAnythingResponse= openAIService.askAnything("What is AI");

       // System.out.println(askAnythingResponse);

    }

}
