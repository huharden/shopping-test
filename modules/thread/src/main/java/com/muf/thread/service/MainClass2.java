package com.muf.thread.service;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;


/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-04-25-15:20
 */
@SuppressWarnings("all")
public class MainClass2 {

    public static void main(String[] args) {
        //核心池大小
        int corePoolSize = 10;
        //线程池最大能接受多少线程
        int maximumPoolSize = 10;
        //线程池最大队列
        int capacity = 10240;
        //当前线程数大于corePoolSize、小于maximumPoolSize时，超出corePoolSize的线程数的生命周期
        long keepActiveTime = 60;

        final MyService service = new MyService();
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("MyService").build();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepActiveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(capacity), threadFactory);
        MyService myService = new MyService();
        for(int i=0;  i<5; i++){
            pool.execute(myService);
        }


    }
}
