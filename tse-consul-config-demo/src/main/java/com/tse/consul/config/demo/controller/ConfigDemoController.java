package com.tse.consul.config.demo.controller;

import com.tse.consul.config.demo.config.DemoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigDemoController {

    @Autowired
    private DemoConfig config;

    @RequestMapping("/echo-config")
    public String getConfigContent(){
        return "get config name : " + config.getName() + ", get config value : " + config.getValue();
    }
}
