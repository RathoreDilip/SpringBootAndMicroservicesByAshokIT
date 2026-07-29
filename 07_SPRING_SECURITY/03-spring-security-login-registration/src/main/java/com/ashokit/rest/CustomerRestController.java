package com.ashokit.rest;

import com.ashokit.entity.Customer;
import com.ashokit.repository.CustomerRepository;
//import com.ashokit.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private JWTService jwtService;


    // secured method
    @GetMapping("/welcome")
    public String getWelcomeMsg(){
        return "Welcome to Ashok IT..";
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCheck(@RequestBody Customer customer){
        System.out.println("LoginCheck called...");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                new UsernamePasswordAuthenticationToken(customer.getEmail(),customer.getPassword());

        try {
            Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            if(authenticate.isAuthenticated()) {
               // String jwt=jwtService.generateToken(customer.getEmail());
                return new ResponseEntity<>("Valid Login.. Welcome to Ashok IT.. Login Successfully..", HttpStatus.OK);
//                return new ResponseEntity<>(jwt, HttpStatus.OK);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return new ResponseEntity<>("Invalid Login Credentials",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){

        String encodePassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodePassword);

        Customer customerSave = customerRepository.save(customer);

        return new ResponseEntity<>(customerSave, HttpStatus.CREATED);
    }

}
