package com.kellylin1115.interview.java.basic;

import java.io.*;

public class CopyFile {
    public static void copy(File oldFile, File newFile){
        InputStream inputStream = null ;
        BufferedInputStream bufferedInputStream = null ;

        OutputStream outputStream = null ;
        BufferedOutputStream bufferedOutputStream = null ;

        try {
            inputStream = new FileInputStream( oldFile ) ;
            bufferedInputStream = new BufferedInputStream( inputStream ) ;

            outputStream = new FileOutputStream( newFile ) ;
            bufferedOutputStream = new BufferedOutputStream( outputStream ) ;

            byte[] b=new byte[1024];   //代表一次最多读取1KB的内容

            int length = 0 ; //代表实际读取的字节数
            while( (length = bufferedInputStream.read( b ) )!= -1 ){
                //length 代表实际读取的字节数
                bufferedOutputStream.write(b, 0, length );
            }
            //缓冲区的内容写入到文件
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {

            if( bufferedOutputStream != null ){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( inputStream != null ){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ( outputStream != null ) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/main/java/com/kellylin1115/interview/java/basic/";
        String inputPath = path + "input.txt";
        String outputPath = path + "output.txt";
        File file = new File( inputPath ) ;
        File file2 = new File( outputPath ) ;
        copy( file , file2 );
    }

}
