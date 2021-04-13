package com.tse.consul.provider.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulProviderController {


    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/ping/{param}")
    public String ping(@PathVariable String param){
        String result = "request param: " + param + ", response from " + applicationName;
        return result;
    }
}
