package com.jasato.pr17.cachedThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Executor {

    private final ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    void execute(Pow pow) {
        try {
            cachedThreadPool.execute(pow);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    void shutdown() throws InterruptedException {
        cachedThreadPool.shutdown();
        if (cachedThreadPool.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.printf(" Cached Executor -> Terminated. Completed: %d\n",
                    cachedThreadPool.getCompletedTaskCount());
        } else {
            System.out.printf("Executor -> Await termination timeout. Completed: %d\n",
                    cachedThreadPool.getCompletedTaskCount());
        }
    }
}
