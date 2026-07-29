package com.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfigure {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails u1= User.withDefaultPasswordEncoder()
                .username("deep")
                .password("deep")
                .build();

        UserDetails u2=User.withDefaultPasswordEncoder()
                .username("raju")
                .password("raju@123")
                .build();

        return new InMemoryUserDetailsManager(u1,u2);
    }

    // SecurityFilterChain
    @Bean
    public SecurityFilterChain securityConfig(HttpSecurity httpSecurity) throws Exception {

            httpSecurity.authorizeHttpRequests(req -> {
                            req.requestMatchers("/welcome","/about-us","/contact-us")
                           .permitAll()
                           .anyRequest()
                           .authenticated();
            }).httpBasic(Customizer.withDefaults())
                    .formLogin(Customizer.withDefaults());

            return httpSecurity.build();
    }

}
