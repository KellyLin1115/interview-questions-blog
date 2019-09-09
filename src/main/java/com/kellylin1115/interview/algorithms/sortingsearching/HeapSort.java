package com.kellylin1115.interview.algorithms.sortingsearching;

public class HeapSort {
    private HeapSort(){}
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param pq the array to be sorted
     */
    public static void sort(int[] pq){
        int n = pq.length;
        for (int i = n/2; i > 0 ; i--) {
            sink(pq, i, n-1);
        }
        for (int i = n-1; i > 0; i--) {
            exch(pq, 1, i);
            sink(pq, 1, i-1);
        }
    }

    private static void sink(int[] pq, int k, int n){
        while(2 * k <= n){
            int j = 2 * k;
            if((j + 1) <= n && pq[j+1] > pq[j]) j= j+ 1;
            if(pq[k] >= pq[j]) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static void exch(int[] pq, int i, int j){
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {0, 17, 7, 12, 11, 13, 5, 6, 90, 9};
        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Sorted array: ");
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
