package com.springboot.demo;

import com.springboot.demo.security.AppSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.springboot.demo","com.oracle"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// never re-commanded to write @Bean in Application main class, we can write @Bean instance inside configuration class

//	@Bean
//	public AppSecurity createAppSecurity(){
//		System.out.println("Security app method called...");
//		AppSecurity security=new AppSecurity("AES");
//		return security;
//	}

}
