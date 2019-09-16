package com.kellylin1115.interview.algorithms.stringarray;



public class ConvertZigZag {
    private ConvertZigZag() {}
    
    public static void convert(int[] arr){
        int n = arr.length;
        boolean isSmaller = true;
        for (int i = 0; i < n - 1 ; i++) {
            if((isSmaller && arr[i] > arr[i + 1]) || (!isSmaller && arr[i] < arr[i+1])){
               int tmp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = tmp;
            }
            isSmaller = !isSmaller;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        convert(arr);
        for (int item : arr)
            System.out.print(item + ",");
    }
}
