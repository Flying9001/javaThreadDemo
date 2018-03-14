package com.ljq.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 同步线程
 * @author: lujunqiang
 * @email: flying9001@gmail.com
 * @date: 2018/3/13
 */
public class SyncTask {

    private static final Logger logback = LoggerFactory.getLogger(SyncTask.class);

    public synchronized void doTask1(){

        for (int i = 0; i < 10; i++) {
            logback.debug("doTask1 is running " + i);
        }
    }

    public synchronized void doTask2(){

        for (int i = 0; i < 10; i++) {
            logback.debug("doTask2 is running " + i);
        }
    }


}
