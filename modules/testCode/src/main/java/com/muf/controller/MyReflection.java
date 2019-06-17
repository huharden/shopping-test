package com.muf.controller;

import com.muf.common.annotation.MyAnnotation;
import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-06-17-10:58
 */
public class MyReflection
{
    public static void main(String[] args) throws Exception
    {
        MyTest myTest = new MyTest();
        Class<MyTest> c = MyTest.class;
        Method method = c.getMethod("output", new Class[] {});
        //如果MyTest类名上有注解@MyAnnotation修饰，则为true
        if(MyTest.class.isAnnotationPresent(MyAnnotation.class))
        {
            System.out.println("have annotation");
        }
        if (method.isAnnotationPresent(MyAnnotation.class))
        {
            //调用output方法
            method.invoke(myTest, null);
            //获取方法上注解@MyAnnotation的信息
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            String hello = myAnnotation.hello();
            String world = myAnnotation.world();
            //打印属性hello和world的值
            System.out.println(hello + ", " + world);
            //打印属性array数组的长度
            System.out.println(myAnnotation.array().length);
            System.out.println(myAnnotation.style());
        }

    }
}
