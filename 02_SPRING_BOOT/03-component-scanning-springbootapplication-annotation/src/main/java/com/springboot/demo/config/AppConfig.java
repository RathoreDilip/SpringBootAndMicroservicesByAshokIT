package com.springboot.demo.config;

import com.springboot.demo.security.AppSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
	public AppSecurity createAppSecurity(){
		System.out.println("Security app method called...");
		AppSecurity security=new AppSecurity("AES");
		return security;
	}
}
