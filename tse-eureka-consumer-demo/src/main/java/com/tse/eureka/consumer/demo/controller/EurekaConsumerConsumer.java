package com.tse.eureka.consumer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaConsumerConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ping-provider/{param}")
    public String ping(@PathVariable String param){
        return restTemplate.getForObject("http://eureka-demo-provider/ping/" + param, String.class);
    }


}
