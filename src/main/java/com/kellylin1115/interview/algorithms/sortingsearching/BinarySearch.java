package com.kellylin1115.interview.algorithms.sortingsearching;

public class BinarySearch {

    // Iterative implementation of Binary Search
    public int binarySearch(int[] array, int key){
        int l = 0;
        int h = array.length - 1;
        while(l <= h){
            int mid = l + ((h - l) / 2);
            if(key  > array[mid]){
                l = mid + 1;
            }else if(key < array[mid]){
                h = mid - 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    //Recursive implementation of Binary Search
    public int binarySearchRecursive(int[] array, int key){
        return binarySearchRecursive(array, 0, array.length-1, key);
    }

    private int binarySearchRecursive(int[] array, int l, int h, int key){
        if(l <= h){
            int mid = l + ((h - l) / 2);
            if(key  > array[mid]){
                return binarySearchRecursive(array, mid + 1, h, key);
            }else if(key < array[mid]){
                return binarySearchRecursive(array, l, mid - 1, key);
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch bs = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40};
        int x = 40;
        int result = bs.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}
