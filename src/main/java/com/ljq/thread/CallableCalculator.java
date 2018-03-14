package com.ljq.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @Desccription: calculator with callable
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/13
 */
public class CallableCalculator implements Callable<Integer>{

    private static final Logger logback = LoggerFactory.getLogger(CallableCalculator.class);

    private int x = 3;
    private int y = 5;

    public CallableCalculator(){

    }

    public CallableCalculator(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        int sum = x+y;
        logback.debug(x + " + " + y + " = " + sum);
        return sum;
    }
}
