package com.muf.thread.controller;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.muf.thread.test.Station;

import java.util.List;
import java.util.concurrent.*;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-03-22-14:44
 */
public class MainController {

    public static void main(String[] args){
        //核心池大小
        int corePoolSize = 10;
        //线程池最大能接受多少线程
        int maximumPoolSize = 10;
        //线程池最大队列
        int capacity = 10240;
        //当前线程数大于corePoolSize、小于maximumPoolSize时，超出corePoolSize的线程数的生命周期
        long keepActiveTime = 60;
        //创建线程规范
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("sendMsgTask-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepActiveTime, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(capacity),namedThreadFactory);
        //任务列表
        List<FutureTask<Integer>> taskList = new ArrayList<>();
        //已做完的任务数量，用来判断所有任务是否都完成
        List<Integer> doneTaskNum = new ArrayList<>();
        Integer errorSum = 0;

        for(List<UsersEntity> userList:userLists){
            SendMsgTask sendMsgTask = new SendMsgTask(msgEntity,fileEntityList,userList,params,messageUtils);
            FutureTask<Integer> futureTask = new FutureTask<Integer>(sendMsgTask);
            taskList.add(futureTask);
            pool.execute(futureTask);
        }

        //等待任务完成，一直遍历线程池每个线程的状态
        while (true){
            try{
                for (int i=0;i<taskList.size();i++){
                    FutureTask<Integer> task = taskList.get(i);
                    //如果当前任务处于done状态（完成）,并且doneTaskNum里面没有存放当前任务，则存进去
                    if(task.isDone()&&(!doneTaskNum.contains(i))){
                        doneTaskNum.add(i);
                        errorSum+=task.get();
                    }
                    //当doneTaskNum的长度与taskList长度一样，证明任务全部完成
                    if(doneTaskNum.size()==taskList.size()){
                        //关闭线程池
                        pool.shutdown();
                        logger.info("总错误数："+errorSum);
                        logger.info("任务结束！");
                        return errorSum;
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
