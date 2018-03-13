package com.ljq.demo;

import com.ljq.utils.TaskCallable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desccription: create threadpool with Future interface
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/13
 */
public class FuturePoolDemo {

    private static final Logger logback = LoggerFactory.getLogger(FuturePoolDemo.class);

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        TaskCallable task = new TaskCallable();
        service.submit(task);
        logback.debug("..........");
        service.submit(task);
        service.shutdown();
    }


}
