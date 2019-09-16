package com.kellylin1115.interview.java.multithreading;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("All threads arrived at barrier point");
            }
        });
        for (int i = 0; i < 2; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread() + " arrived barrier point 1");
                        barrier.await();

                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread() + " arrived barrier point 2");
                        barrier.await();

                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread() + " arrived barrier point 3");
                        barrier.await();
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
            };
            exec.execute(task);
        }
        exec.shutdown();
    }
}
