package com.jasato.pr17.fixedThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Executor {

    private final ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    void execute(Pow pow) {
        try {
            fixedThreadPool.execute(pow);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    void shutdown() throws InterruptedException {
        fixedThreadPool.shutdown();
        if (fixedThreadPool.awaitTermination(20, TimeUnit.SECONDS)) {
            System.out.printf("Fixed Executor -> Terminated. Completed: %d\n",
                    fixedThreadPool.getCompletedTaskCount());
        } else {
            System.out.printf("Fixed Executor -> Await termination timeout. Completed: %d\n",
                    fixedThreadPool.getCompletedTaskCount());
        }
    }
}
