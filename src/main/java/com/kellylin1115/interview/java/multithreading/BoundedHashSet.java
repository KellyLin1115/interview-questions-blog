package com.kellylin1115.interview.java.multithreading;

import java.util.*;
import java.util.concurrent.Semaphore;

public class BoundedHashSet<T> {

    private final Semaphore permits;
    private final Set<T> set;

    public BoundedHashSet(int bound){
        permits = new Semaphore(bound);
        set = Collections.synchronizedSet(new HashSet<>());
    }

    public boolean add(T item) throws InterruptedException{
        permits.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(item);
            return wasAdded;
        }finally{
            if(!wasAdded)
                permits.release();
        }
    }

    public boolean remove(T item) throws InterruptedException{
        boolean wasRemoved = set.remove(item);
        if(wasRemoved)
            permits.release();
        return wasRemoved;
    }

}
