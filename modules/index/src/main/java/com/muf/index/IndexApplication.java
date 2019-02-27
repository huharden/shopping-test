package com.muf.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-27-17:17
 */
@SpringBootApplication
@EnableEurekaClient
public class IndexApplication {
    public static void main(String[] args){
        SpringApplication.run(IndexApplication.class, args);
    }
}
