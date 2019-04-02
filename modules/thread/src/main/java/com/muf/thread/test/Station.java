package com.muf.thread.test;

import com.muf.common.exception.RRException;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-03-22-14:40
 */
public class Station extends Thread{

    private static int num = 1;
    private static int ticket = 100;
    private static Object lock = "a";
    public Station(String name){
        super(name);
    }

    @Override
    public void run(){
        while (num <= ticket){
            synchronized (lock){
                if(num <= ticket){
                    System.out.println(getName()+"卖出第"+ num +"票");
                    num++;
                }else{
                    System.out.println("票已经售完");
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw  new RRException("服务异常", e);
            }
        }
    }

}
