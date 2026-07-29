package com.ashokit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

    @GetMapping("product")
    public ResponseEntity<String> getProductInfo(@RequestParam("id") Integer id){
        String msg="";
        if(id == 101)
            msg="Apple Mobile Price :: 850000 INR";
        else if(id == 102)
            msg="Samsung Mobile Price :: 65000 INR";
        else
            msg="No Product Found";

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<String> getProductInfoPath(@PathVariable("id") Integer id){
        String msg="";
        if(id == 101)
            msg="Apple Mobile Price :: 850000 INR";
        else if(id == 102)
            msg="Samsung Mobile Price :: 65000 INR";
        else
            msg="No Product Found";

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }



}
