package com.ljq.demo;

import com.ljq.task.PrintTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Desccription: thread join() demo
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/14
 */
public class ThreadSignalDemo {

    private static final Logger logback = LoggerFactory.getLogger(ThreadSignalDemo.class);

    public static void main(String[] args) {
//        signalDemo1();
//        signalDemo2();
//        signalDemo3();
        signalDemo4();

    }


    /**
     * 线程通讯测试一: Thread.join()
     * 有线程 A 和 B ，线程 B 在线程 A 执行结束之后再执行
     * (单个线程等待单个线程, A - B)
     *
     * */
    public static void signalDemo1(){

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                logback.debug("thread A start");
                new PrintTask().doPrint("Thread A ");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                logback.debug("thread B start");
                try {
                    threadA.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new PrintTask().doPrint("Thread B ");
            }
        });
        threadB.start();
        threadA.start();
    }

    /**
     * 线程通讯测试二: wait(),notify()
     * 有线程 A 和 B，线程 A 执行一段时间之后,线程 B 开始执行，线程 B 执行结束之后,线程 A 继续执行
     * (两个线程交叉运行, A - B - A )
     *
     * */
    public static void signalDemo2(){
        PrintTask printTask = new PrintTask();

        Thread threadA  = new Thread(new Runnable() {
            @Override
            public void run() {
                logback.debug("thread A start");
                synchronized (printTask){
                    printTask.doPrint("Thread A ");
                    try {
                        printTask.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printTask.doPrint("Thread A ");
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                logback.debug("thread B start");
                synchronized (printTask) {
                    printTask.doPrint("Thread B ");
                    printTask.notify();
                }
            }
        });
        threadA.start();
        threadB.start();
    }

    /**
     * 线程通讯测试三: CountdownLatch
     * 有四个线程 A,B,C,D,其中其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
     * (单个线程等待多个线程,A,B,C - D)
     *
     * */
    public static void signalDemo3(){
        int num = 3;
        CountDownLatch countDownLatch = new CountDownLatch(num);

        // Thread D
        new Thread(new Runnable() {
            @Override
            public void run() {
                logback.debug("Thread D start");
                try {
                    countDownLatch.await();
                    new PrintTask().doPrint("Thread D ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Thread A,B,C
        for (char threadName = 'A'; threadName < 'D'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        logback.debug("Thread " + tN + " start ");
                        new PrintTask().doPrint("Thread " + tN );
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    logback.debug("Thread " + tN + " finished ");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }


    /**
     * 线程通讯测试四: CyclicBarrier
     * 有三个线程,A,B,C,三个线程同步/异步启动，待三个线程全部启动完成后，再同步运行
     * (多个线程等待单个/多个线程, A ... - A,B,C ...)
     * */
    public static void signalDemo4(){
        int num = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num);

        final Random random = new Random();
        for(char threadName  = 'A'; threadName < 'D'; threadName++){
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new PrintTask().doPrint("Thread " + tN );
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        logback.debug("Thread " + tN + " is prepared");
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    logback.debug("Thread " + tN + "is running");
                }
            }).start();
        }
    }

    /**
     * 子线程执行结束之后，将执行结果返回到主线程
     * 可以通过实现 Callable 接口，获取线程运行结果，但是在获取结果的时候，会阻塞主线程
     * 因此，实现该功能推荐使用 线程池
     * 见: com.ljq.demo.FuturePoolDemo
     * */



}
