package com.muf.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-04-02-14:57
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/test")
    public void login(){
        Jedis jedis = new Jedis("123.207.27.144",6379);
        for(int i=0;i<100;i++){
            jedis.hset("key"+i,"keyvalue:"+i,"keyfield"+i);
        }
    }
}
