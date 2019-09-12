package com.kellylin1115.interview.algorithms.stringarray;

public class ReverseWithoutSpecial {

    private ReverseWithoutSpecial() {}

    public static String reverse(String ss){
        StringBuilder stringBuilder = new StringBuilder();
        char[] str = ss.toCharArray();
        int n = str.length;
        int l = -1;
        int r = n;
        while(l < r){
            while(l < (n-1)){
                if(Character.isAlphabetic(str[++l])) break;
            };
            while(r > 0){
                if(Character.isAlphabetic(str[--r])) break;
            };
            if(l < r) swap(str, l, r);
            else break;
        }

        for (char c : str)
            stringBuilder.append(c);
        return stringBuilder.toString();
    }

    private static void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "a!!!b.c.d,e'f,ghi";
        System.out.println(" Input string: " + str);

        String revStr = reverse(str);
        System.out.println("Output string: " + revStr);

    }
}
