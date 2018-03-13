package com.ljq.demo;

import com.ljq.utils.TaskRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desccription: Thread pool with Runnable interface
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/13
 */
public class RunnablePoolDemo {

    private static final Logger logback = LoggerFactory.getLogger(RunnablePoolDemo.class);

    public static void main(String[] args) {

        // 创建线程池对象，包含10个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 创建 Runnable 线程任务对象
        TaskRunnable task = new TaskRunnable();
        // 从线程池中获取对象
        service.submit(task);
        logback.debug("----------------------");
        // 在获取一个线程对象
        service.submit(task);
        // 关闭线程池
        service.shutdown();

    }


}
