package com.muf.controller;


import com.muf.common.annotation.MyAnnotation;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-06-17-10:52
 */
public class MyTest {
    @MyAnnotation(hello = "beijing", world="广州",array={},style=int.class)
    public void output()
    {
        System.out.println("output something!");
    }
}
