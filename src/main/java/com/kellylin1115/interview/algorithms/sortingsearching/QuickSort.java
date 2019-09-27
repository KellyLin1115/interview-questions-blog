package com.kellylin1115.interview.algorithms.sortingsearching;

import java.util.Random;

public class QuickSort {
    private QuickSort(){}

    public static void sort(int[] arr){
        shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int h){
        if(l < h) {
            int k = partition(arr, l, h);
            sort(arr, l, k - 1);
            sort(arr, k + 1, h);
        }
    }

    private static int partition(int[] arr, int l, int h){
        int pivot = arr[l];
        int i = l, j = h + 1;
        while(true) {
            while(arr[++i] < pivot){
                if (i == h) {
                    swap(arr, l, i);
                    return i;
                }
            }
            while(arr[--j] > pivot){
                if (j == l + 1) return l;
            }

            if(j > i) {
                swap(arr, i, j);
            }else{
                swap(arr, j, l);
                return j;
            }
        }
    }

    private static void shuffle(int[] arr){
        Random rand = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n-i);
            int tmp = arr[r];
            arr[r] = arr[i];
            arr[i] = tmp;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 17, 7, 12, 11, 13, 5, 6, 90, 9, 1};
        QuickSort qs = new QuickSort();
        qs.sort(arr);

        System.out.println("Sorted array: ");
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
