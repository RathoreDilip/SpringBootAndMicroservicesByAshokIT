package com.ashokit.service;

import com.ashokit.binding.Order;
import com.ashokit.contstants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public String pushMsgToKafka(Order order){
        kafkaTemplate.send(AppConstants.TOPIC,order);
        return "Msg Pushed to Kafka Topic";
    }


}
