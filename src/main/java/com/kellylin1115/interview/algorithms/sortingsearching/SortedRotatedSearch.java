package com.kellylin1115.interview.algorithms.sortingsearching;

public class SortedRotatedSearch {
    public int search(int[] array, int key){
        int l = 0;
        int h = array.length - 1;
        while(l <= h){
            int mid = l + ((h - l)/2);
            if(array[mid] == key) return mid;

            //if left part of array is sorted
            if(array[l] <= array[mid]){
                if(array[l]<= key &&  key < array[mid]){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                //if left part of array is unsorted, right part of array must be sorted
                if(key > array[mid] && key <= array[h]){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        SortedRotatedSearch srs = new SortedRotatedSearch();
        int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3};
        int x = 8;
        int result = srs.search(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}
