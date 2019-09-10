package com.kellylin1115.interview.algorithms.sortingsearching;

import java.util.Random;

public class FindKthSmallest {

    private FindKthSmallest(){}

    public static int select(int[] arr, int k){
        int n = arr.length;
        if(k > n ) throw new IllegalArgumentException("K " + k + " is bigger than array size " + n);
        int index = select(arr, 0, n - 1, k);
        return arr[index];
    }

    private static int select(int[] arr, int l, int h, int k){
        int i = partition(arr, l, h);
        if((i-l+1) == k ) return i;
        else if(k < (i-l+1)) return select(arr, l, i - 1, k);
        else return select(arr, i + 1, h, k - (i - l + 1));
    }

    private static int partition(int[] arr, int l, int h){
        //Randomly pick up a pivot and swap with the first element
        Random rand = new Random();
        int r = l + rand.nextInt(h - l + 1);
        swap(arr, r, l);

        int pivot = arr[l];
        int i = l, j = h + 1;
        while(i + 1 < j){
            while(i < h){
                if(arr[++i] >= pivot) break;
                if(i == h) {
                    swap(arr, l, i);
                    return i;
                }
            }
            while(j > (l + 1)){
                if(arr[--j] <= pivot) break;
                if(j == (l + 1)) return l;
            }
            if(i < j){
                swap(arr, i, j);
            }else{
                swap(arr, l, j);
                return j;
            }
        }
        swap(arr, l, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        System.out.println(FindKthSmallest.select(arr, 3));
    }
}
