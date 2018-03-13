package com.ljq.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desccription: thread demo
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/13
 */
public class ThreadUtil extends Thread{

    private static final Logger logback = LoggerFactory.getLogger(ThreadUtil.class);

    private Thread thread;
    private String threadName;

    public ThreadUtil(String threadName){
        this.threadName = threadName;
        logback.debug("Creating: " + threadName);
    }

    public void run() {
        logback.debug("Running: " + threadName);
        try {
            for (int i = 0; i < 5; i++) {
                logback.debug("Thread: " + threadName + ", " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            logback.error("Thread " + threadName + "interrupted.");
            e.printStackTrace();
        }
        logback.debug("Thread " + threadName + " exiting.");
    }
    public void start(){
        logback.debug("Starting " + threadName);
        if (thread == null){
            thread = new Thread(this,threadName);
            thread.start();
        }
    }





}
