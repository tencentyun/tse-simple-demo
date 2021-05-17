package com.tse.dubbo.zookeeper.consumer.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tse.dubbo.zookeeper.api.service.*;
import com.alibaba.dubbo.config.annotation.Reference;


@RestController
public class ConsumerController {
	@Reference(version = "${demo.service.version}")
	private IHelloworldService helloWorld;
	@Reference(version = "${demo.service.version}")
	private IHelloworldService2 helloWorld2;

	@RequestMapping("/dubbo/helloWorld")
	public String helloWorld() {
		return helloWorld.dubbo();
	}
	@RequestMapping("/dubbo/helloWorld2")
	public String helloWorld2() {
		return helloWorld2.dubbo();
	}
}
