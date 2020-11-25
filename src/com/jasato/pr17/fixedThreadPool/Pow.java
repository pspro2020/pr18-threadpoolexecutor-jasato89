package com.jasato.pr17.fixedThreadPool;

public class Pow implements Runnable {

    private static final int NUM_TIMES = 20;
    private final double number;

    public Pow(double number) {
        this.number = number;
    }


    @Override
    public void run() {
        for (int i = 1; i <= NUM_TIMES; i++) {
            System.out.printf("%s: %.0f ^ %.0f = %.0f\n", Thread.currentThread().getName(), number, (double)i, Math.pow(number, i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
