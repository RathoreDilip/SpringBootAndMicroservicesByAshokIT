package com.ashokit.config;

import com.ashokit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfigure {

    @Autowired
    private CustomerService customerService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // load customer db record and perform to authenticate
    @Bean
    public AuthenticationProvider authenticationProvider(){
        System.out.println("AppSecurityConfigure - AuthenticationProvider Called...");
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(customerService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    // AuthenticationManager is used to perform authentication and that internally talk to authenticationProvider
    // Password comparison match by AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        System.out.println("AppSecurityConfigure - AuthenticationManager Called...");
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(req -> {
                    req.requestMatchers("/register","/login")
                            .permitAll()
                            .anyRequest()
                            .authenticated();
        }).csrf(csrf -> csrf.disable());

        //.httpBasic(Customizer.withDefaults())
              //  .formLogin(Customizer.withDefaults())

        return httpSecurity.build();
    }

}
