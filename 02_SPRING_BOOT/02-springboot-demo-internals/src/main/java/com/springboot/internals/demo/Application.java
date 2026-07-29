package com.springboot.internals.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

		System.out.println(run.getClass().getName()); // org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext

		System.out.println(run.getBeanDefinitionCount()); // predefined classes loaded 157

	}

}
