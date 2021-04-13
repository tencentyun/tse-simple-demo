package com.tse.zookeeper.consumer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZookeeperConsumerController {

    @Service
    @FeignClient(name = "zookeeper-demo-provider")
    public interface ZkProviderClient {
        @GetMapping("/echo/{param}")
        String echo(@PathVariable String param);
    }

    @Autowired
    private ZkProviderClient client;

    @GetMapping("/ping/{param}")
    public String ping(@PathVariable String param){
        return client.echo(param);
    }

}
