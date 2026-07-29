package com.ashokit;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MsgService {

    private static final String PROVIDER_URL="https://api.restful-api.dev/objects/";

    public void getMsg(){
        RestTemplate restTemplate=new RestTemplate();

        ResponseEntity<String> forEntity = restTemplate.getForEntity(PROVIDER_URL, String.class);

        System.out.println("Status code: "+forEntity.getStatusCode());

        System.out.println("Response body : "+forEntity.getBody());

//        restTemplate.

    }


}
