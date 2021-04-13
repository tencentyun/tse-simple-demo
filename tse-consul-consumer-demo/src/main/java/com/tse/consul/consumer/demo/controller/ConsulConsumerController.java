package com.tse.consul.consumer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsulConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ping-provider/{param}")
    public String ping(@PathVariable String param){
        return restTemplate.getForObject("http://consul-demo-provider/ping/" + param, String.class);
    }

}
