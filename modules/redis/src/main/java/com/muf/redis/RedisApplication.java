package com.muf.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-27-17:17
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.muf.redis.*", "com.muf.common.*"})
public class RedisApplication {
    public static void main(String[] args){
        SpringApplication.run(RedisApplication.class, args);
    }
}
