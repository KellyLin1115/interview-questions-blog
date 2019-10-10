package com.kellylin1115.interview.java.basic;

import java.io.*;
import java.util.*;


public class Test {

    public static void main(String[] args) throws IOException{
        FileReader fileReader = new FileReader("db.properties");
        Properties p = new Properties();
        p.load(fileReader);
        System.out.println(p.getProperty("user"));
        System.out.println(p.getProperty("password"));

    }

}

