package com.tse.dubbo.zookeeper.provider.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo
@SpringBootApplication
public class DubboZookeeperProviderDemo {

	public static void main(String[] args) {
		SpringApplication.run(DubboZookeeperProviderDemo.class, args);
	}
}
