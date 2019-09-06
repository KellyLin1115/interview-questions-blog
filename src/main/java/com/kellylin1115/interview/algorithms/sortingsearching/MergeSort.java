package com.kellylin1115.interview.algorithms.sortingsearching;

public class MergeSort {
    public static void sort(int[] array){
        int n = array.length;
        mergeSort(array, 0, n - 1);
    }

    private static void mergeSort(int[] array, int l, int h){
        if(l < h) {
            int mid = l + ((h - l) / 2);
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, h);
            merge(array, l, mid, h);
        }
    }

    private static void merge(int[] array, int l, int mid, int h){
        int[] auxiliary = new int[h-l+1];
        int j = l, k = mid + 1, p = 0;
        while(j <= mid && k <= h){
            if(array[j]<=array[k]){
                auxiliary[p++] = array[j++];
            }else{
                auxiliary[p++] = array[k++];
            }
        }

        if(j <= mid){
            for (int i = j; i <= mid; i++) {
                auxiliary[p++] = array[i];
            }
        }

        if(k <= h){
            for (int i = k; i <= h; i++) {
                auxiliary[p++] = array[i];
            }
        }

        for (int i = l; i <= h; i++) {
            array[i] = auxiliary[i - l];
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7, 90};
        MergeSort ms = new MergeSort();
        ms.sort(arr);

        System.out.println("Sorted array: ");
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
