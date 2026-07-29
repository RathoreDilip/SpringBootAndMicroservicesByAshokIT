package com.ashokit;

import com.ashokit.dao.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		UserDAO userDAO = context.getBean(UserDAO.class);
		System.out.println(userDAO.hashCode());

		UserDAO userDAO2 = context.getBean(UserDAO.class);
		System.out.println(userDAO2.hashCode());

		UserDAO userDAO3 = context.getBean(UserDAO.class);
		System.out.println(userDAO3.hashCode());

	}

}
