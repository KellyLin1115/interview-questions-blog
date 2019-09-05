package com.kellylin1115.interview.algorithms.sortingsearching;

public class SortedRotatedSearch {
    public int search(int[] array, int key){
        int l = 0;
        int h = array.length - 1;
        while(l <= h){
            int mid = l + ((h - l)/2);
            if(key > array[mid]){
                if(key < array[h]) {
                    l = mid + 1;
                }else if(key > array[h]){
                    h = mid - 1;
                }else {
                    return h;
                }
            }else if(key < array[mid]){
                if(key < array[l]){
                    l = mid + 1;
                }else if(key > array[l]){
                    h = mid - 1;
                }else{
                    return l;
                }
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        SortedRotatedSearch srs = new SortedRotatedSearch();
        int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3};
        int x = 6;
        int result = srs.search(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}
