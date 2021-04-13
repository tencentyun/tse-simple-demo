package com.tse.zookeeper.config.demo.config;

import org.apache.zookeeper.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

@Order(-1)
@Configuration
public class PreConfig {
    @Value("${spring.cloud.zookeeper.connect-string}")
    private String connStr;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.cloud.zookeeper.config.root}")
    private String configRoot;

    @PostConstruct
    public void putStringToZK() {
        doPut("tomDog");
    }

    public boolean doPut(String value) {
        try {
            System.out.printf("Get app %s connect address: %s. \n", appName, connStr);

            String key = "/" + configRoot;
            ZooKeeper zk = new ZooKeeper(connStr, 10000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("receive event..." + event);
                }
            });

            if (zk.exists(key, false) == null) {
                zk.create(key, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            System.out.printf("Put %s to zk success. \n", key);

            key += "/" + appName;
            if (zk.exists(key, false) == null) {
                zk.create(key, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            System.out.printf("Put %s to zk success. \n", key);

            key += "/" + "demo.name";
            if (zk.exists(key, false) == null) {
                zk.create(key, value.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            } else {
                zk.setData(key, value.getBytes(StandardCharsets.UTF_8), -1);
            }
            System.out.printf("Put %s to zk success. \n", key);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}
