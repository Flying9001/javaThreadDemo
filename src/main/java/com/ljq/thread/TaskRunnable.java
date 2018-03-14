package com.ljq.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desccription: task Runnable class
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/13
 */
public class TaskRunnable implements Runnable{

    private static final Logger logback = LoggerFactory.getLogger(TaskRunnable.class);

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            logback.debug("Thread running " + i);
        }

    }
}
