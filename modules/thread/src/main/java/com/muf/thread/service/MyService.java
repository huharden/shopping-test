package com.muf.thread.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-04-25-10:53
 */
public class MyService implements Runnable{
    private Lock lock = new ReentrantLock();
    public void methodA() {
        try {
            lock.lock();  //加锁，作用相当于synchronized

            System.out.println(Thread.currentThread().getName()+" 进入methodA  并得到锁");

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+" 离开methodA  并释放锁");
            lock.unlock(); //释放锁
        }

    }

   public void methodB() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" 进入methodB  并得到锁");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+" 离开methodB  并释放锁");
            lock.unlock();
        }
    }

    @Override
    public  void run(){
        this.methodA();
        System.out.println("-----------------"+Thread.currentThread().getName());
    }

}
