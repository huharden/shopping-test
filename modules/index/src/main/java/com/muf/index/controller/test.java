package com.muf.index.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-27-17:19
 */
@RestController
@RequestMapping("test")
public class test {
    @GetMapping("gat")
     public void gateWayTest(){
         System.out.println("test"+"111111");
     }

}
