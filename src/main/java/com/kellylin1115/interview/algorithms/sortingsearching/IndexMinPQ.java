package com.kellylin1115.interview.algorithms.sortingsearching;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer>{
    private int maxN; // maximum number of elements on PQ
    private int n; // number of elements on PQ
    private int[] pq; // binary heap using 1-based indexing
    private int[] qp; //inverse of pq: qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;

    public IndexMinPQ(int maxN){
        if(maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i < maxN + 1; i++) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public boolean contain(int i){
        if(i < 0 || i >= maxN) throw new IllegalArgumentException();
        return qp[i] != -1;
    }

    public int size(){
        return n;
    }

    public void insert(int i, Key key){
        if(contain(i)) throw new IllegalArgumentException("index " + i + " is already in priority queue");
        n++;
        keys[i] = key;
        pq[n] = i;
        qp[i] = n;
        swim(n);
    }

    public int delMin(){
        if(n == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = -1;
        keys[min] = null;
        qp[min] = -1;
        return min;
    }

    private void swim(int k){
        while(k > 1 && greater(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2 * k <= n ){
            k = 2*k;
            if(k < n && greater(k, k + 1)) k = k + 1;
            if(!greater(k/2, k)) break;
            exch(k, k/2);
        }
    }

    private boolean greater(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j){
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public Iterator<Integer> iterator(){
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer>{
        private IndexMinPQ<Key> copy;
        public HeapIterator(){
            copy = new IndexMinPQ<>(pq.length - 1);
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i], keys[pq[i]]);
            }
        }

        public boolean hasNext(){
            return !copy.isEmpty();
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Integer next(){
            if(!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }

    public static void main(String[] args) {
        // insert a bunch of strings
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

        IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }

        // delete and print each key
        while (!pq.isEmpty()) {
            int i = pq.delMin();
            System.out.println(i + " " + strings[i]);
        }
        System.out.println();

        // reinsert the same strings
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }

        // print each key using the iterator
        for (int i : pq) {
            System.out.println(i + " " + strings[i]);
        }
        while (!pq.isEmpty()) {
            pq.delMin();
        }

    }
}