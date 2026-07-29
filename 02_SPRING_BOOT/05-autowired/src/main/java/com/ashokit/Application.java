package com.ashokit;

import com.ashokit.service.UserService;
import com.ashokit.zbest.practice.service.EmpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService userService = context.getBean(UserService.class);
		String name = userService.getName(1);
		System.out.println("Name : "+name);

		System.out.println("---------- Best Practice ----------------- ");
		EmpService empService = context.getBean(EmpService.class);
		name=empService.getName(2);
		System.out.println("Name : "+name);

	}

}
