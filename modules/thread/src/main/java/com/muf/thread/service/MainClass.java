package com.muf.thread.service;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-04-25-15:20
 */
public class MainClass {

    public static void main(String[] args){
            final MyService service = new MyService();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    service.methodA();
                }

            }).start();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    service.methodA();
                }

            }).start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    service.methodB();
                }

            }).start();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    service.methodB();
                }

            }).start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    service.methodB();
                }

            }).start();


    }
}
