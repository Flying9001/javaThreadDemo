package com.ljq.demo;

import com.ljq.utils.ThreadUtil;

/**
 * @Desccription: Thread demo
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/13
 */
public class ThreadDemo {


    public static void main(String[] args) {
        ThreadUtil thread1 = new ThreadUtil("Thread-1");
        thread1.start();

        ThreadUtil thread2 = new ThreadUtil("Thread-2");
        thread2.start();

    }

}
