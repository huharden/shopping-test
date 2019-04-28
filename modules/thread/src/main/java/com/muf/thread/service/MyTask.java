package com.muf.thread.service;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-04-25-16:30
 */
public class MyTask implements Runnable{
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行task "+taskNum +"----" + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task "+taskNum+"执行完毕");
        }
}
