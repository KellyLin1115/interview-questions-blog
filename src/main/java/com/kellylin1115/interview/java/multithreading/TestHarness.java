package com.kellylin1115.interview.java.multithreading;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(){
                public void run(){
                    try {
                        startGate.await();
                        try {
                            task.run();
                        }finally{
                                endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();

        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        TestHarness th = new TestHarness();
        System.out.println("Time: " + th.timeTasks(3, task));
    }
}
