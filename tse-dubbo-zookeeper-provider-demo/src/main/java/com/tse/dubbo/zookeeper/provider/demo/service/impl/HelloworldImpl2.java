package com.tse.dubbo.zookeeper.provider.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tse.dubbo.zookeeper.api.service.*;

@Service(version = "${demo.service.version}")
public class HelloworldImpl2 implements IHelloworldService2 {

	@Override
	public String dubbo() {

		return "hello world2!";

	}

}
