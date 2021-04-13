package com.tse.consul.provider.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZookeeperProviderController {
    
    @GetMapping("/echo/{param}")
    public String helloWorld(@PathVariable String param) {
        System.out.printf("ZK Provider receive request param: %s\n", param);
        return "provider echo: " + param;
    }
}
