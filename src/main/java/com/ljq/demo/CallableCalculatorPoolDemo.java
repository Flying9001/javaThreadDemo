package com.ljq.demo;

import com.ljq.utils.CallableCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Desccription: calculator thread pool with Callable
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/13
 */
public class CallableCalculatorPoolDemo {

    private static final Logger logback = LoggerFactory.getLogger(CallableCalculatorPoolDemo.class);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        CallableCalculator calculator1 = new CallableCalculator();
        CallableCalculator calculator2 = new CallableCalculator(20,30);
        CallableCalculator calculator3 = new CallableCalculator(30,50);
        try {
            Future<Integer> result1 = service.submit(calculator1);
            Integer sum1 = result1.get();
            logback.debug("sum1: "  + sum1);
            result1 = service.submit(calculator2);
            sum1 = result1.get();
            logback.debug("sum2: " + sum1);
            result1 = service.submit(calculator3);
            sum1 = result1.get();
            logback.debug("sum3: " + sum1);

            // 关闭线程池(也可以不关闭)
            service.shutdown();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
