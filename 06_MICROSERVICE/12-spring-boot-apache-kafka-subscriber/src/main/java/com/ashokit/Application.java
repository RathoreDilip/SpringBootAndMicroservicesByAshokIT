package com.ashokit;

import com.ashokit.contstants.AppConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @KafkaListener(topics = AppConstants.TOPIC,groupId = "group_ashokit_order")
    public void subscribeKafkaTopic(String order){

        System.out.println("******** Msg received from Topic *******");
        System.out.println(order);

        // logic to process to msg
    }

}
