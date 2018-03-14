package com.ljq.demo;

import com.ljq.task.SyncTask;

/**
 * @description: 线程同步测试
 * @author: lujunqiang
 * @email: flying9001@gmail.com
 * @date: 2018/3/13
 */
public class ThreadsyncDemo {


    /**
     * 当一个线程访问object的一个synchronized同步代码块或同步方法时，其他线程对object中所有其它synchronized
     * 同步代码块或同步方法的访问将被阻塞
     * */
    public static void main(String[] args) {

        SyncTask syncTask = new SyncTask();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncTask.doTask1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncTask.doTask2();
            }
        });

        thread1.start();
        thread2.start();


    }


}
