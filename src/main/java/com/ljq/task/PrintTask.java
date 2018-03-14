package com.ljq.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desccription: print result task
 * @author: Thaumaturge
 * @email: lujunqiang@ancun.com
 * @date: 2018/3/14
 */
public class PrintTask {

    private static final Logger logback = LoggerFactory.getLogger(PrintTask.class);

    public void doPrint(String strDemo){
        for (int i = 0; i < 3; i++) {
            logback.debug("strDemo: " + strDemo + ", " + i);
        }
    }


}
