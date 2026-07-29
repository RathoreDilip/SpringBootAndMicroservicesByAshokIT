package com.ashokit;

import com.ashokit.entity.User;
import com.ashokit.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        UserService userService = applicationContext.getBean(UserService.class);

        userService.saveUserWithRoles();

    }

}
