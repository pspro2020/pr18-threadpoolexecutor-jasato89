package com.jasato.pr17.fixedThreadPool;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_TIMES = 10;

    public static void main(String[] args) {
        Executor executor = new Executor();

        for (int i = 1; i <= NUM_TIMES; i++) {
            executor.execute(new Pow((double)i));

        }


        try {
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
