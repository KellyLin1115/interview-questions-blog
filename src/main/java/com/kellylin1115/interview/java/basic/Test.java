package com.kellylin1115.interview.java.basic;

public class Test {
    private static int i = 1;
    public void add(){
        i = i+1;
    }
    public static void main(String[] args) {
        System.out.println(args==null);
        Test t = new Test();
        t.add();
        System.out.println(Test.i);
    }

}
