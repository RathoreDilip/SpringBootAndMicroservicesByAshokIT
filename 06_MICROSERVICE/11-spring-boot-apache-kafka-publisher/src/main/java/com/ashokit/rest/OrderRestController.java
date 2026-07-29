package com.ashokit.rest;

import com.ashokit.binding.Order;
import com.ashokit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public String createOrder(@RequestBody Order order){
        return orderService.pushMsgToKafka(order);
    }

}
