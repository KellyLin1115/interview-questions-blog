package com.kellylin1115.interview.java.multithreading;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private final String poolName;
    public MyThreadFactory(String poolName){
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable){
        return new MyAppThread(runnable, poolName);
    }
}
