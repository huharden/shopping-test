package com.muf.thread.service;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * 工作总往往会遇到异步去执行某段逻辑, 然后先处理其他事情, 处理完后再把那段逻辑的处理结果进行汇总的场景, 这时候就需要使用线程了.
 * 一个线程启动之后, 是异步的去执行需要执行的内容的, 不会影响主线程的流程,  往往需要让主线程指定后, 等待子线程的完成. 这里有几种方式.
 * 站在主线程的角度, 我们可以分为主动式和被动式.
 * 主动式指主线程主动去检测某个标志位, 判断子线程是否已经完成. 被动式指主线程被动的等待子线程的结束, 很明显, 比较符合人们的胃口.
 * 就是你事情做完了, 你告诉我
 * 该demo主要针对 被动式
 *
 * @author: hutao
 * Date: 2019-04-25-17:47
 */
@Slf4j
public class CountDownDemo {
    public static void main(String[] args) throws Exception {
        //定义线程数
        int subThreadNum = 5;
        //取得一个倒计时器，从5开始
        CountDownLatch countDownLatch = new CountDownLatch(subThreadNum);
        //依次创建5个线程，并启动
        for (int i = 0; i < subThreadNum; i++) {
            new SubThread(2000*(i+1), countDownLatch).start();
        }
        //主线程工作
        mainWork();
        //等待所有的子线程结束
        countDownLatch.await();
        System.out.println("Main Thread work done!" + "end......");
    }
    private static void mainWork(){
        System.out.println("Main thread start work!");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            log.error("系统错误", e.getMessage());
        }
        System.out.println("Main Thread work done!"+ "mainThread");
    }
    /**
     * 子线程类
     * @author fuhg
     */
    private static class SubThread extends Thread{

        private CountDownLatch countDownLatch;
        private long workTime;

        public SubThread(long workTime,CountDownLatch countDownLatch){
            this.workTime = workTime;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("Sub thread is starting!");
                Thread.sleep(workTime);
                System.out.println("Sub thread is stopping!");
            } catch (InterruptedException e) {
                log.error("系统错误", e.getMessage());
            } finally {
                //线程结束时，将计时器减一
                countDownLatch.countDown();
            }
        }
    }
}
