package com.tse.dubbo.zookeeper.consumer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;


@EnableDubbo
@SpringBootApplication
public class DubboZookeeperConsumerDemo {

	public static void main(String[] args) {
		SpringApplication.run(DubboZookeeperConsumerDemo.class, args);
	}
}
