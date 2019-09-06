package com.kellylin1115.interview.algorithms.sortingsearching;

public class InsertionSort {
    public static void sort(int[] array){
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 ; j--) {
                if(array[j] < array[j - 1]){
                    swap(array, j, j - 1);
                }else{
                    break;
                }
            }
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
