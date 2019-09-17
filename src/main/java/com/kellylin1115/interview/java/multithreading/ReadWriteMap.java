package com.kellylin1115.interview.java.multithreading;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteMap<K, V> {
    private final Map<K, V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock r = lock.readLock();
    private final Lock w = lock.writeLock();

    public ReadWriteMap(Map<K, V> map){
        this.map = map;
    }

    public V put(K key, V value){
        try {
            w.lock();
            return map.put(key, value);
        }finally{
            w.unlock();
        }
    }

    public V get(K key){
        try{
            r.lock();
            return map.get(key);
        }finally{
            r.unlock();
        }
    }
}
