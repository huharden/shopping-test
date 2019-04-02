package com.muf.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-04-02-14:57
 */
@RestController
@RequestMapping("/login")
public class LoginController {


    @GetMapping("/hashSet")
    public void login(){
        Jedis jedis = new Jedis("123.207.27.144",6379);
        for(int i=0;i<100;i++){
            jedis.hset("key"+i,"keyvalue:"+i,"keyfield"+i);
            //redisUtils.cleanKey("key"+i);
        }
    }

    @GetMapping("/pipeLine")
    public void pipeLine(){
        // new 一个 Redis，它提供 IP 和端口号的参数
        Jedis jedis = new Jedis("127.0.0.1",6379);
        for(int i=0;i<100;i++){
            // 此句就是使用 pipelined 方法，激活pipeline
            Pipeline pipeline = jedis.pipelined();
            for(int j=i*100;j<(i+1)*100;j++){
                pipeline.hset("pipeLinedKey"+j,"pipeLinedKeyField"+j,"pipeLinedKeyValue"+j);
            }
            pipeline.syncAndReturnAll();//结束的时候必须要加的
        }
    }
}
