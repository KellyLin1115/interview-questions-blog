package com.kellylin1115.interview.algorithms.sortingsearching;

public class BubbleSort {
    public static void sort(int[] array){
        int n = array.length;
        boolean swap;
        for (int i = 0; i < n; i++) {
            swap = false;
            for (int j = 1; j < n - i; j++) {
                if(array[j-1] > array[j]){
                    swap(array, j-1, j);
                    swap = true;
                }
            }
            if(!swap) break;
        }
    }

    private static void swap(int[] array, int i , int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 22, 34, 25, 12, 22, 11, 90 };
        sort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
