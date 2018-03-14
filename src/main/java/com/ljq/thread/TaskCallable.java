package com.ljq.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @Desccription: callable class
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/13
 */
public class TaskCallable implements Callable<Object>{

    private static final Logger logback = LoggerFactory.getLogger(TaskCallable.class);

    @Override
    public Object call() throws Exception {

        for (int i = 0; i < 12; i++) {
            logback.debug("Thread running " + i);
        }
        return null;
    }
}
