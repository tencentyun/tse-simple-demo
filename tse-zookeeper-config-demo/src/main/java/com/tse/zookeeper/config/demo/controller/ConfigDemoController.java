package com.tse.zookeeper.config.demo.controller;

import com.tse.zookeeper.config.demo.config.DemoConfig;
import com.tse.zookeeper.config.demo.config.PreConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigDemoController {

    @Autowired
    private PreConfig preConfig;

    @Autowired
    private DemoConfig config;

    @RequestMapping("/echo-config")
    public String getConfigContent(){
        return "get config user name : " + config.getName() + "\n";
    }

    @RequestMapping("/change/{param}")
    public boolean changeConfigContent(@PathVariable String param){
        return preConfig.doPut(param);
    }
}
