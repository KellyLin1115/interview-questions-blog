package com.kellylin1115.interview.algorithms.stringarray;

import java.util.Arrays;

public class CountTriplets {
    private CountTriplets() {}

    public static int count(int[] arr, int sum){
        Arrays.sort(arr);
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                if ((arr[i] + arr[j] + arr[k]) >= sum){
                    k--;
                }else {
                    res += k - j;
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{5, 1, 3, 4, 7};
        int sum = 12;
        System.out.println(count(arr, sum));
    }
}
