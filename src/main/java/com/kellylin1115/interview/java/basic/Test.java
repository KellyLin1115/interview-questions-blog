package com.kellylin1115.interview.java.basic;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) throws IOException{
        String path = System.getProperty("user.dir") + "/src/main/java/com/kellylin1115/interview/java/basic/";

        FileInputStream in = null;
        FileOutputStream out = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            in = new FileInputStream(path + "input.txt");
            bis = new BufferedInputStream(in);
            byte[] bytes = new byte[32];

            out = new FileOutputStream(path + "output.txt");
            bos = new BufferedOutputStream(out);

            int c;
            while((c = bis.read(bytes)) != -1){
                bos.write(bytes, 0, c);
            }
            bos.flush();
        }finally{
            if(bis != null){
                bis.close();
            }
            if(in != null){
                in.close();
            }
            if(bos != null){
                bos.close();
            }
            if(out != null){
                out.close();
            }
        }


    }

}

