package com.kellylin1115.interview.java.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        ExecutorService exec = Executors.newFixedThreadPool(2);
        Runnable producer = new IntegerProducer(queue);
        Runnable consumer = new IntegerConsumer(queue);
        exec.execute(producer);
        exec.execute(consumer);
        try {
            Thread.sleep(20000);
        }catch(InterruptedException e){
            System.out.println(Thread.currentThread() + " interrupted");
        }
        exec.shutdownNow();
    }
}

class IntegerProducer implements Runnable {
    BlockingQueue<Integer> queue;
    Random rand = new Random();
    public IntegerProducer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                int j = rand.nextInt(100);
                queue.put(j);
                System.out.println("Added " + j);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + " interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}

class IntegerConsumer implements Runnable {
    BlockingQueue<Integer> queue;
    public IntegerConsumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Waiting to fetch: ");
                int j = queue.take();
                System.out.println("Fetched " + j);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + " interrupted");
            }
        }
    }
}