package com.ljq.demo;

import com.ljq.thread.RunnableUtil;

/**
 * @Desccription: runnable demo
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/13
 */
public class RunnableDemo {

    public static void main(String[] args) {
        RunnableUtil demo1 = new RunnableUtil("demo-1");
        demo1.start();

        RunnableUtil demo2 = new RunnableUtil("demo-2");
        demo2.start();

    }
}
