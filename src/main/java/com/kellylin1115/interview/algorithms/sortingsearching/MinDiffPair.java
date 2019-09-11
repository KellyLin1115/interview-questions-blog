package com.kellylin1115.interview.algorithms.sortingsearching;

public class MinDiffPair {

    private MinDiffPair(){}

    public static String minDiffPair(int[] arr, int x){
        int minDiff = Integer.MAX_VALUE;
        int minL = -1;
        int minR = -1;
        int l = 0, r = arr.length - 1;
        while(l < r){
            int sum = arr[l] + arr[r];
            int diff = Math.abs(sum - x);
            if( diff < minDiff){
                minDiff = diff;
                minL = l;
                minR = r;
            }
            if(sum < x) l++;
            else r--;
        }

        return "(" + arr[minL] + ", " + arr[minR] + ")";
    }

    public static void main(String[] args) {

        //Output: 22 and 30
        int arr1[] = {10, 22, 28, 29, 30, 40};
        int x1 = 54;
        System.out.println(MinDiffPair.minDiffPair(arr1, x1));

        //4 and 10
        int arr2[] = {1, 3, 4, 7, 10};
        int x2 = 15;
        System.out.println(MinDiffPair.minDiffPair(arr2, x2));
    }
}
