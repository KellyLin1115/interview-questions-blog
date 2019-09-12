package com.kellylin1115.interview.algorithms.stringarray;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PrintAllPalindrome {
    private PrintAllPalindrome() {}

    public static void printAllPalindrome(String input){
        ArrayList<ArrayList<String>> allPalindrome = new ArrayList<>();
        Deque<String> current = new LinkedList<>();
        partitions(allPalindrome, current, input, 0, input.length());

        for (int i = 0; i < allPalindrome.size(); i++) {
            System.out.println();
            for (int j = 0; j < allPalindrome.get(i).size() ; j++) {
                System.out.print(allPalindrome.get(i).get(j) + " ");
            }
        }
    }

    private static void partitions(ArrayList<ArrayList<String>> allPalindrome, Deque<String> current, String input, int start, int n){
        if(start >= n){
            allPalindrome.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < n; i++) {
            if(isPalindrome(input, start, i)){
                current.add(input.substring(start, i + 1));
                partitions(allPalindrome, current, input, i+1, n);
                current.removeLast();
            }
        }

    }

    private static boolean isPalindrome(String input, int start, int end){
        while(start < end){
            if(input.charAt(start++) != input.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
          String input = "nitin";
          System.out.println("All possible palindrome partitions for " + input + " are: ");
          printAllPalindrome(input);
    }
}
